package collections.simple_map

import jmh.{BenchmarkBase, SimpleFilterBenchmark, SimpleMapBenchmark}
import org.openjdk.jmh.infra.Blackhole

import scala.collection.mutable

class ScalaFor extends SimpleMapBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    val result = mutable.MutableList[Int]()
    for (value <- someList) {
      result += transform(value)
    }
    result
  }
}