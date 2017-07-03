package collections.simple_filter;

import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;
import jmh.SimpleFilterBenchmark;

import java.util.ArrayList;
import java.util.List;

public class JavaFor extends SimpleFilterBenchmark<List> {

    private ArrayList<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh){
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected List doWork() {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer value: someList){
            if (filter(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
