package collections.chain

import jmh.ChainBenchmark
import org.openjdk.jmh.infra.Blackhole
import scala.collection.JavaConverters._

class ScalaFor extends ChainBenchmark[Seq[Int]] {
  lazy val someList = (0 until collectionSize).toList

  override def prepare(bh: Blackhole) = {
    bh.consume(someList.head)
  }

  override def doWork() = {
    var result = initialValue()
    for {
      value <- someList
      item <- generate(value).asScala
    } {
      if (filter(item)) {
        result = doFold(result, item)
      }
    }
    result
  }
}