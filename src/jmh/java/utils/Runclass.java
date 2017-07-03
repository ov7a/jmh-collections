package utils;


import collections.simple_fold.JavaStreams;
import jmh.BenchmarkBase;
import org.openjdk.jmh.infra.Blackhole;

public class Runclass {
    public static void main(String[] args) {
        BenchmarkBase benchmark = new JavaStreams();

        //TODO: change collection size
        benchmark.prepare(new Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous."));

        Object result = benchmark.benchmark();
        System.out.println(result);
    }
}
