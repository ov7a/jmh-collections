package collections.simple_filter

import jmh.{BenchmarkBase, SimpleFilterBenchmark}
import org.openjdk.jmh.infra.Blackhole

class ScalaFilter extends SimpleFilterBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    someList.filter(filter(_))
  }
}