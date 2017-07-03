package collections.simple_filter;

import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;
import jmh.SimpleFilterBenchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams extends SimpleFilterBenchmark<List> {

    private ArrayList<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh){
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected List doWork() {
        return someList.stream().filter(this::filter).collect(Collectors.toList());
    }
}
