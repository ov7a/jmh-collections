package collections.complex_chain;

import jmh.ChainBenchmark;
import jmh.ComplexChainBenchmark;
import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStreams extends ComplexChainBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh) {
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected List<Integer> doWork() {
        return someList
                .stream()
                .collect(Collectors.groupingBy(
                        this::grouping, Collectors.toList()
                ))
                .entrySet()
                .stream()
                .map((entry) -> {
                    Integer value = entry
                            .getValue()
                            .stream()
                            .filter(this::filter)
                            .map(this::transform)
                            .mapToInt((x) -> x)
                            .sum();

                    return new Pair<>(entry.getKey(), value);
                })
                .sorted(Comparator.comparingInt((x) -> -x.second))
                .limit(10)
                .map((x) -> x.first)
                .collect(Collectors.toList());
    }

    class Pair<F, S> {
        F first;
        S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
