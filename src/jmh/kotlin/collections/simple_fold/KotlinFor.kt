package collections.simple_fold

import jmh.BenchmarkBase
import jmh.SimpleFoldBenchmark
import jmh.SimpleMapBenchmark
import org.openjdk.jmh.infra.Blackhole
import java.util.ArrayList

open class KotlinFor : SimpleFoldBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize){it}
    }

    override fun doWork(): Int {
        var result = initialValue()
        for (value in someList) {
            result = doFold(result, value)
        }
        return result
    }
}
