package collections.complex_chain

import jmh.ChainBenchmark
import jmh.ComplexChainBenchmark
import org.openjdk.jmh.infra.Blackhole

open class KotlinSequence : ComplexChainBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize) { it }
    }

    override fun doWork(): List<Int> {
        return someList
                .asSequence()
                .groupBy(this::grouping)
                .mapValues {
                    it.value
                            .asSequence()
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
