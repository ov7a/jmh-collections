package collections.simple_flatmap

import jmh.{SimpleFlatMapBenchmark, SimpleMapBenchmark}
import org.openjdk.jmh.infra.Blackhole

import scala.collection.mutable
import scala.collection.JavaConverters._

class ScalaFor extends SimpleFlatMapBenchmark[Seq[Integer]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    val result = mutable.MutableList[Integer]()
    for (value <- someList) {
      result ++= generate(value).asScala
    }
    result
  }
}