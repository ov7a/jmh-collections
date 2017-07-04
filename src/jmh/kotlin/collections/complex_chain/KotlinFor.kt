package collections.complex_chain

import jmh.ChainBenchmark
import jmh.ComplexChainBenchmark
import org.openjdk.jmh.infra.Blackhole

open class KotlinFor : ComplexChainBenchmark<List<*>>() {

    lateinit var someList: List<Int>

    override fun prepare(bh: Blackhole) {
        someList = List(collectionSize){it}
    }

    override fun doWork(): List<*> {
        val sums = mutableMapOf<Int, Int>()
        for (element in someList) {
            val key = grouping(element)
            if (filter(element)) {
                val current = sums.getOrPut(key, { 0 })
                sums.put(key, current + transform(element))
            }
        }
        val sumsSorted =  sums.entries.sortedByDescending { it.value }
        val result = mutableListOf<Int>()
        for (i in (0..9)){
            if (sumsSorted.size <= i){
                break
            }
            result += sumsSorted[i].key
        }
        return result
    }
}
