package collections.simple_map

import jmh.BenchmarkBase
import jmh.SimpleMapBenchmark
import org.openjdk.jmh.infra.Blackhole
import java.util.ArrayList

open class KotlinMap : SimpleMapBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize){it}
    }

    override fun doWork(): List<*> {
        return someList.map(this::transform)
    }
}
