package jmh;

public abstract class SimpleFoldBenchmark<T> extends BenchmarkBase<T, Integer> {
    protected Integer initialValue(){
        return 1235;
    }

    protected Integer doFold(Integer value1, Integer value2) {
        return value1 + value2;
    }

}
