package collections.complex_chain;

import jmh.ChainBenchmark;
import jmh.ComplexChainBenchmark;
import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;

import java.lang.reflect.Array;
import java.util.*;

public class JavaFor extends ComplexChainBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh) {
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected List<Integer> doWork() {
        Map<Integer, Integer> sums = new HashMap<>();
        for (Integer element : someList) {
            Integer key = grouping(element);
            if (filter(element)) {
                Integer current = sums.get(key);
                if (current == null) {
                    sums.put(key, transform(element));
                } else {
                    sums.put(key, current + transform(element));
                }
            }
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(sums.entrySet());
        entries.sort(Comparator.comparingInt((x) -> -x.getValue()));
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (entries.size() <= i){
                break;
            }
            result.add(entries.get(i).getKey());
        }
        return result;
    }
}
