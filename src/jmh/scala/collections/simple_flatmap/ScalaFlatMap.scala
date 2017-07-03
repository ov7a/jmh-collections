package collections.simple_flatmap

import jmh.SimpleFlatMapBenchmark
import org.openjdk.jmh.infra.Blackhole

import scala.collection.JavaConverters._

class ScalaFlatMap extends SimpleFlatMapBenchmark[Seq[Integer]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    someList.flatMap(generate(_).asScala)
  }
}