package collections.complex_chain

import jmh.ComplexChainBenchmark
import org.openjdk.jmh.infra.Blackhole

import scala.collection.mutable

class ScalaFor extends ComplexChainBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    val sums = mutable.Map.empty[Int, Int]
    for (element <- someList) {
      val key = grouping(element)
      if (filter(element)) {
        val current = sums.getOrElseUpdate(key, 0)
        sums(key) = current + transform(element)
      }
    }
    val sumsSorted = sums.toSeq.sortBy(-_._2)
    val result = mutable.MutableList[Int]()
    for (i <- 0 until 10) {
      if (i < sumsSorted.size) {
        result += sumsSorted(i)._1
      }
    }
    result
  }
}