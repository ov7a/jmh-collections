package collections.simple_filter

import jmh.BenchmarkBase
import jmh.SimpleFilterBenchmark
import org.openjdk.jmh.infra.Blackhole
import java.util.ArrayList

open class KotlinFor : SimpleFilterBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize){it}
    }

    override fun doWork(): List<*> {
        val result = mutableListOf<Int>()
        for (value in someList) {
            if (filter(value)) {
                result.add(value)
            }
        }
        return result
    }
}
