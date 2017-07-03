package collections.simple_flatmap

import jmh.SimpleFlatMapBenchmark
import jmh.SimpleMapBenchmark
import org.openjdk.jmh.infra.Blackhole

open class KotlinFlatMap : SimpleFlatMapBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize) { it }
    }

    override fun doWork(): List<*> {
        return someList.flatMap(this::generate)
    }
}
