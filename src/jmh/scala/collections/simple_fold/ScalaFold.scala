package collections.simple_fold

import jmh.{SimpleFoldBenchmark, SimpleMapBenchmark}
import org.openjdk.jmh.infra.Blackhole

class ScalaFold extends SimpleFoldBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    someList.fold(initialValue().toInt)(doFold(_, _))
  }
}