package collections.chain

import jmh.BenchmarkBase
import jmh.ChainBenchmark
import jmh.SimpleFoldBenchmark
import jmh.SimpleMapBenchmark
import org.openjdk.jmh.infra.Blackhole
import java.util.ArrayList

open class KotlinFor : ChainBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize){it}
    }

    override fun doWork(): Int {
        var result = initialValue()
        for (value in someList) {
            for (item in generate(value)){
                if (filter(item)){
                    result = doFold(result, item)
                }
            }
        }
        return result
    }
}
