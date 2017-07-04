package collections.complex_chain

import jmh.ComplexChainBenchmark
import org.openjdk.jmh.infra.Blackhole

open class KotlinChain : ComplexChainBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize) { it }
    }

    override fun doWork(): List<*> {
        return someList
                .groupBy(this::grouping)
                .mapValues {
                    it.value
                            .filter(this::filter)
                            .map(this::transform)
                            .sum()
                }
                .entries
                .sortedByDescending { it.value }
                .take(10)
                .map { it.key }

    }
}
