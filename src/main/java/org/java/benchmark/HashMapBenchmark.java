package org.java.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.java.Main.*;

/**
 * Измерение времени основных операций в HashMap
 * (вставка ключ-значение/получение значения по ключу)
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = WARM_UP_ITERATIONS)
@Measurement(iterations = MEASUREMENT_ITERATIONS)
@Fork(FORKS)
public class HashMapBenchmark {

    private static final int MAP_SIZE = 131072;

    private int key, value;
    private Map<Integer, Integer> map1;
    private Map<Integer, Integer> map2;

    @Setup(Level.Iteration)
    public void prepareMap() {
        map1 = new HashMap<>(MAP_SIZE, 1);
        for (int i = 0; i < MAP_SIZE - 1; i++) {
            map1.put(i, i);
        }
        map2 = new HashMap<>(MAP_SIZE, 1);
        for (int i = 0; i < MAP_SIZE; i++) {
            map2.put(i, i);
        }
        key = MAP_SIZE;
        value = MAP_SIZE;
    }

    /**
     * Вставка ключ-значение
     */
    @Benchmark
    public void put() {
        map1.put(key, value);
    }

    /**
     * Вставка ключ-значение с увеличением размера таблицы
     */
    @Benchmark
    public void putWithResize() {
        map2.put(key, value);
    }

    /**
     * Получение значения по ключу
     */
    @Benchmark
    public Integer get() {
        return map2.get(MAP_SIZE - 1);
    }
}
