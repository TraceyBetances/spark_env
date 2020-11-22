package spark_env

import org.apache.spark.sql.{DataFrame, SparkSession}
import spark_env.FuncionesConstantes._
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._


object TraitProcess extends TraitStructure {

  override def etl1(): Unit = {

    val spark: SparkSession = SparkSession
      .builder
      .appName("TraitTest")
      .enableHiveSupport
      .getOrCreate()

    import spark.implicits._

    val path = "file:///home/isamed/training_materials/devsh/data/accounts.csv"
    val readCSV = spark.read.option("header","true").schema(schemaAccounts_csv).option("sep",",").csv(path)
      .select(
        $"acct_num".as("numero_cuenta"),
        $"acct_create_dt".as("fecha_creacion"),
        $"acct_close_dt".as("fecha_cierre"),
        $"first_name".as("nombre"),
        $"last_name".as("apellido"),
        $"address".as("direccion"),
        $"city".as("ciudad"),
        $"state".as("estado"),
        $"zipcode".as("codigo_postal"),
        $"phone_number".as("telefono"),
        $"created".as("creacion"),
        $"modified".as("modificacion"))
      .withColumn("nombreApellido", concat_ws(" ",col("nombre"),col("apellido")))
      .withColumn("city", upper(col("city")))


    val database = spark.sql(s"""create database if not exists ${nameDatabase}""")
    val createTable = spark.sql(
      s"""
         |CREATE EXTERNAL TABLE IF NOT EXISTS ${nameTable}
         |(numero_cuenta string,
         |fecha_creacion string,
         |fecha_cierre string,
         |nombre string,
         |apellido string,
         |direccion string
         |ciudad string
         |estado string,
         |codigo_postal string,
         |telefono string,
         |creacion string,
         |modificacion string)
         |STORED AS PARQUET
         |LOCATION ${locationTableHDFS}""".stripMargin)

    val tablaTemAccountsOK = readCSV.createOrReplaceTempView("TemAccounts")
    val insertData = spark.sql(
      s"""
         |INSERT OVERWRITE TABLE ${nameTable}
         |SELECT * FROM TemAccounts """.stripMargin)

    println("Datos insertados CORRECTAMENTE")

  }

  def main(args: Array[String]): Unit = {

    etl1()

  }

}
