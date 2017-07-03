package collections.simple_map;

import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;
import jmh.SimpleMapBenchmark;

import java.util.ArrayList;
import java.util.List;

public class JavaFor extends SimpleMapBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh){
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected List doWork() {
        List<Integer> result = new ArrayList<>();
        for (Integer value: someList){
            result.add(transform(value));
        }
        return result;
    }
}
