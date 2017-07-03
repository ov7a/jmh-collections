package collections.simple_filter

import jmh.{BenchmarkBase, SimpleFilterBenchmark}
import org.openjdk.jmh.infra.Blackhole

import scala.collection.mutable

class ScalaFor extends SimpleFilterBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    val result = mutable.MutableList[Int]()
    for (value <- someList) {
      if (filter(value)) {
        result += value
      }
    }
    result
  }
}