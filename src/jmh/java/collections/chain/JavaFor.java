package collections.chain;

import jmh.ChainBenchmark;
import jmh.SimpleFlatMapBenchmark;
import org.openjdk.jmh.infra.Blackhole;
import utils.CollectionInitializer;

import java.util.ArrayList;
import java.util.List;

public class JavaFor extends ChainBenchmark<List> {

    private List<Integer> someList = new ArrayList<>();

    @Override
    public void prepare(Blackhole bh){
        CollectionInitializer.init(someList, collectionSize);
    }

    @Override
    protected Integer doWork() {
        Integer result = initialValue();
        for (Integer value: someList){
            for(Integer item: generate(value)){
                if (filter(item)){
                    result = doFold(result, item);
                }
            }
        }
        return result;
    }
}
