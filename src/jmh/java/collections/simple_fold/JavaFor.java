package collections.simple_fold;

import jmh.SimpleFoldBenchmark;
import jmh.SimpleMapBenchmark;
import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;

import java.util.ArrayList;
import java.util.List;

public class JavaFor extends SimpleFoldBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh){
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected Integer doWork() {
        Integer result = initialValue();

        for (Integer value: someList){
            result = doFold(result, value);
        }
        return result;
    }
}
