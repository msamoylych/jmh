package org.java.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import static org.java.Main.*;

/**
 * Измерение времени основных операций в TreeMap
 * (вставка ключ-значение/получение значения по ключу)
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = WARM_UP_ITERATIONS)
@Measurement(iterations = MEASUREMENT_ITERATIONS)
@Fork(FORKS)
public class TreeMapBenchmark {

    private static final Random rnd = new Random(1234567890L);
    private static final int MAP_SIZE = 131072;

    private int key, value;
    private Map<Integer, Integer> baseMap;
    private Map<Integer, Integer> map;

    @Setup(Level.Trial)
    public void prepareBaseMap() {
        baseMap = new TreeMap<>();
        for (int i = 0; i < MAP_SIZE; i++) {
            int r;
            while (baseMap.containsKey(r = rnd.nextInt(MAP_SIZE))) ;
            baseMap.put(r, r);
        }
        key = MAP_SIZE;
        value = MAP_SIZE;
    }

    @Setup(Level.Iteration)
    public void prepareMap() {
        map = (TreeMap) ((TreeMap) baseMap).clone();
    }

    /**
     * Вставка ключ-значение
     */
    @Benchmark
    public void put() {
        map.put(key, value);
    }

    /**
     * Получение значения по ключу
     */
    @Benchmark
    public Integer get() {
        return map.get(MAP_SIZE - 1);
    }
}
