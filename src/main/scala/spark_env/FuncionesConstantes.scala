package spark_env

import org.apache.spark.sql.types.{StructField, StructType, StringType}

object FuncionesConstantes {

  val nameDatabase = "TraitAccount"
  val nameTable = "accounts_csv"
  val locationTableHDFS = "/tablas_spark-env/" + nameTable

  def schemaAccounts_csv: StructType = {

    StructType(Array(

      StructField("acct_num", StringType, nullable = true),
      StructField("acct_create_dt", StringType, nullable = true),
      StructField("acct_close_dt", StringType, nullable = true),
      StructField("first_name", StringType, nullable = true),
      StructField("last_name", StringType, nullable = true),
      StructField("address", StringType, nullable = true),
      StructField("city", StringType, nullable = true),
      StructField("state", StringType, nullable = true),
      StructField("zipcode", StringType, nullable = true),
      StructField("phone_number", StringType, nullable = true),
      StructField("create", StringType, nullable = true),
      StructField("modified", StringType, nullable = true)))
  }

}
