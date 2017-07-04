package jmh;

import java.util.ArrayList;
import java.util.List;

public abstract class ChainBenchmark<T> extends BenchmarkBase<T, Integer>  {
    protected Integer initialValue(){
        return 1235;
    }

    protected Integer doFold(Integer value1, Integer value2) {
        return value1 + value2;
    }

    protected boolean filter(Integer value){
        return value > 3 && value % 10 == 3;
    }

    protected int smallCollectionSize() {
        return 100;
    }

    protected List<Integer> generate(Integer value) {
        int smallSize = smallCollectionSize();
        List<Integer> result = new ArrayList<>(smallSize);
        for (int i = 0; i < smallSize; i++) {
            result.add(i * value);
        }
        return result;
    }

}
