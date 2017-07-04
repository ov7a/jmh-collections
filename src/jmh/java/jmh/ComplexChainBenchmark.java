package jmh;

import java.util.ArrayList;
import java.util.List;

public abstract class ComplexChainBenchmark<T> extends BenchmarkBase<T, T>  {
    protected boolean filter(Integer value){
        return value % 5 == 3 && value > 10;
    }

    protected Integer grouping(Integer value){
        return value % 31;
    }

    protected Integer transform(Integer value){
        return (value - 5) * 17;
    }

}
