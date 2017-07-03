package collections.simple_flatmap;

import jmh.SimpleFlatMapBenchmark;
import jmh.SimpleMapBenchmark;
import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams extends SimpleFlatMapBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh){
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected List doWork() {
        return someList.stream().flatMap((value) -> generate(value).stream()).collect(Collectors.toList());
    }
}
