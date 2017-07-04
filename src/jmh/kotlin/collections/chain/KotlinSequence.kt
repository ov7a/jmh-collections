package collections.chain

import jmh.ChainBenchmark
import jmh.SimpleFoldBenchmark
import org.openjdk.jmh.infra.Blackhole

open class KotlinSequence : ChainBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize) { it }
    }

    override fun doWork(): Int {
        return someList
                .asSequence()
                .flatMap { generate(it).asSequence() }
                .filter(this::filter)
                .fold(initialValue(), this::doFold)
    }
}
