package collections.simple_flatmap;

import jmh.SimpleFlatMapBenchmark;
import jmh.SimpleMapBenchmark;
import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;

import java.util.ArrayList;
import java.util.List;

public class JavaFor extends SimpleFlatMapBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh){
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected List doWork() {
        List<Integer> result = new ArrayList<>();
        for (Integer value: someList){
            result.addAll(generate(value));
        }
        return result;
    }
}
