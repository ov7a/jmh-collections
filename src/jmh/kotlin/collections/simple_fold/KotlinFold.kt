package collections.simple_fold

import jmh.SimpleFoldBenchmark
import jmh.SimpleMapBenchmark
import org.openjdk.jmh.infra.Blackhole

open class KotlinFold : SimpleFoldBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize){it}
    }

    override fun doWork(): Int {
        return someList.fold(initialValue(), this::doFold)
    }
}
