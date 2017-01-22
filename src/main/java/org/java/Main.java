package org.java;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Измерение времени основных операций в базовых классах
 */
public class Main {

    public static final int WARM_UP_ITERATIONS = 10;
    public static final int MEASUREMENT_ITERATIONS = 100;
    public static final int FORKS = 1;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*Benchmark")
                .build();

        new Runner(opt).run();
    }
}
