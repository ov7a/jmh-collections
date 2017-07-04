package collections.chain

import jmh.{ChainBenchmark, SimpleFoldBenchmark}
import org.openjdk.jmh.infra.Blackhole
import scala.collection.JavaConverters._

class ScalaChain extends ChainBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    someList
    .flatMap(generate(_).asScala)
    .filter(filter)
    .fold(initialValue())(doFold)
  }
}