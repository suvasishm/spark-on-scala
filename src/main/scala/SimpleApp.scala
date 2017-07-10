/**
  * Created by suvasish on 13-Jan-17.
  */

/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp {
    def main(args: Array[String]) {
        val logFile = "C:\\apache\\spark-2.1.1-bin-hadoop2.7\\README.md" // Should be some file on your system
        val conf = new SparkConf().setAppName("Simple Application")
        val sc = new SparkContext(conf)
        val logData = sc.textFile(logFile, 2).cache()
        val numAs = logData.filter(line => line.contains("a")).count()
        val numBs = logData.filter(line => line.contains("b")).count()
        sc.stop()
        println(s"==========================================")
        println(s"Lines with a: $numAs, Lines with b: $numBs")
        println(s"==========================================")
    }
}

