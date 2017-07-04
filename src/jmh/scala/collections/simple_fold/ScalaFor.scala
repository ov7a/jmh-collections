package collections.simple_fold

import jmh.{SimpleFoldBenchmark, SimpleMapBenchmark}
import org.openjdk.jmh.infra.Blackhole

import scala.collection.mutable

class ScalaFor extends SimpleFoldBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    var result = initialValue()
    for (value <- someList) {
      result = doFold(result, value)
    }
    result
  }
}