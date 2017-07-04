package collections.chain

import jmh.ChainBenchmark
import org.openjdk.jmh.infra.Blackhole

import scala.collection.JavaConverters._

class ScalaIterator extends ChainBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    someList
    .iterator
    .flatMap(generate(_).asScala.iterator)
    .filter(filter)
    .fold(initialValue())(doFold)
  }
}