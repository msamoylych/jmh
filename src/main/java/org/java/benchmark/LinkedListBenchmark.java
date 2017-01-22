package org.java.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.java.Main.*;

/**
 * Измерение времени основных операций в LinkedList
 * (вставка/получение значения)
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = WARM_UP_ITERATIONS)
@Measurement(iterations = MEASUREMENT_ITERATIONS)
@Fork(FORKS)
public class LinkedListBenchmark {

    private static final int LIST_SIZE = 100_000;

    private List<Integer> list;
    private int e;

    @Setup(Level.Iteration)
    public void prepareList() {
        list = new LinkedList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(i);
        }
        e = LIST_SIZE;
    }

    /**
     * Вставка в конец
     */
    @Benchmark
    public void addLast() {
        list.add(e);
    }

    /**
     * Вставка в начало
     */
    @Benchmark
    public void addFirst() {
        list.add(0, e);
    }

    /**
     * Вставка в середину
     */
    @Benchmark
    public void addMiddle() {
        list.add(LIST_SIZE / 2, e);
    }

    /**
     * Получение значения из конца
     */
    @Benchmark
    public Integer getLast() {
        return list.get(LIST_SIZE - 1);
    }

    /**
     * Получение значения из начала
     */
    @Benchmark
    public Integer getFirst() {
        return list.get(0);
    }

    /**
     * Получение значения из середины
     */
    @Benchmark
    public Integer getMiddle() {
        return list.get(LIST_SIZE / 2);
    }
}
