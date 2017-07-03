package collections.simple_fold;

import jmh.SimpleFoldBenchmark;
import jmh.SimpleMapBenchmark;
import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams extends SimpleFoldBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh) {
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected Integer doWork() {
        return someList.stream().reduce(initialValue(), this::doFold);
    }
}
