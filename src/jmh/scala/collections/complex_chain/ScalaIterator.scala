package collections.complex_chain

import jmh.ComplexChainBenchmark
import org.openjdk.jmh.infra.Blackhole

class ScalaIterator extends ComplexChainBenchmark[Seq[_]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    someList
    .groupBy(grouping(_))
    .iterator
    .map { case (key, value) =>
      key.toInt -> value
                   .iterator
                   .filter(filter(_))
                   .map(transform(_).toInt)
                   .sum
    }
    .toSeq
    .sortBy(-_._2)
    .take(10)
    .map(_._1)
      .toList
  }
}