package collections.chain;

import jmh.ChainBenchmark;
import jmh.SimpleFlatMapBenchmark;
import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams extends ChainBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh){
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected Integer doWork() {
        return someList
                .stream()
                .flatMap((value) -> generate(value).stream())
                .filter(this::filter)
                .reduce(initialValue(), this::doFold);
    }
}
