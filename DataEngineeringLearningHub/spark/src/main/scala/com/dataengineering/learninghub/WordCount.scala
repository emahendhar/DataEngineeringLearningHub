package com.dataengineering.learninghub

import org.apache.spark.{SparkConf, SparkContext}
object WordCount {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("RDD WordCount - Hello World")
      .setMaster("local[*]")


    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")


    val lines =sc.parallelize(Seq(
      "spark is awesome",
      "I can learn spark with scala",
      "this is spark scala wordcount program"
    ))


    val words = lines.flatMap(_.split("\\s+"))

    val wordpair = words.map(word => (word, 1))

    val wordreduce = wordpair.reduceByKey(_ + _)

    val sortcount = wordreduce.map { case (word, count) => (count, word) }.sortByKey(ascending = false).map { case (count, word) => (word, count) }
    // sort by count


    println("rdd")

    sortcount.take(20).foreach { case (word, count) => println(f"$word%-10s => $count") }


  }
}
