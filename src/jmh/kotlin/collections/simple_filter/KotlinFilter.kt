package collections.simple_filter

import jmh.SimpleFilterBenchmark
import org.openjdk.jmh.infra.Blackhole

open class KotlinFilter : SimpleFilterBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize){it}
    }

    override fun doWork(): List<*> {
        return someList.filter(this::filter)
    }
}
