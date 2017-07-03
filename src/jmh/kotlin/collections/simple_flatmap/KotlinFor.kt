package collections.simple_flatmap

import jmh.BenchmarkBase
import jmh.SimpleFlatMapBenchmark
import jmh.SimpleMapBenchmark
import org.openjdk.jmh.infra.Blackhole
import java.util.ArrayList

open class KotlinFor : SimpleFlatMapBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize){it}
    }

    override fun doWork(): List<*> {
        val result = mutableListOf<Int>()
        for (value in someList) {
            result.addAll(generate(value))
        }
        return result
    }
}
