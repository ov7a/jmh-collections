package collections.simple_map;

import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;
import jmh.SimpleMapBenchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams extends SimpleMapBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh){
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected List doWork() {
        return someList.stream().map(this::transform).collect(Collectors.toList());
    }
}
