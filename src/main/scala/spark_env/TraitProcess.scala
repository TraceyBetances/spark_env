package spark_env

import org.apache.spark.sql.{DataFrame, SparkSession}

object TraitProcess extends TraitStructure {

  override def etl1(): DataFrame = {

    val spark: SparkSession = SparkSession
      .builder
      .appName("TraitTest")
      .enableHiveSupport
      .getOrCreate()

    val path = "file:///home/isamed/training_materials/devsh/data/accounts.csv"
    val readCSV = spark.read.format("csv").option("sep",",").option("header","true").load(path)
    readCSV
  }

  def main(args: Array[String]): Unit = {

    etl1()

  }

}
