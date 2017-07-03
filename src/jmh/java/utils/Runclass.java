package utils;


import collections.simple_fold.JavaStreams;
import jmh.BenchmarkBase;

public class Runclass {
    public static void main(String[] args) {
        BenchmarkBase benchmark = new JavaStreams();

        //TODO: change collection size
        benchmark.prepare(JMHHelper.newBlackhole());

        Object result = benchmark.benchmark();
        System.out.println(result);
    }
}
