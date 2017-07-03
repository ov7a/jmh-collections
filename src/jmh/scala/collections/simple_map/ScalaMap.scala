package collections.simple_map

import jmh.SimpleMapBenchmark
import org.openjdk.jmh.infra.Blackhole

class ScalaMap extends SimpleMapBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    someList.map(transform(_).toInt)
  }
}