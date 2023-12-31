package com.bigdatacompany.sparkhdfs;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class HdfsReader {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir","C:\\hadoop-common-2.2.0-bin-master");

        SparkSession sparkSession = SparkSession.builder().master("local").appName("Hdfs Reader").getOrCreate();

        Dataset<Row> rawData = sparkSession.read().option("header", true).csv("C://police911.csv");

        rawData.coalesce(1).write().csv("hdfs://localhost:8020/data/useridcount");
    }
}
