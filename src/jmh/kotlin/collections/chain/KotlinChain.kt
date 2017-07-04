package collections.chain

import jmh.ChainBenchmark
import jmh.SimpleFoldBenchmark
import org.openjdk.jmh.infra.Blackhole

open class KotlinChain : ChainBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize){it}
    }

    override fun doWork(): Int {
        return someList
                .flatMap(this::generate)
                .filter(this::filter)
                .fold(initialValue(), this::doFold)
    }
}
