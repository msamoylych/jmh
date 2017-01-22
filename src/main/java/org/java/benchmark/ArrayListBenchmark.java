package org.java.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.java.Main.*;

/**
 * Измерение времени основных операций в ArrayList
 * (вставка/получение значения)
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = WARM_UP_ITERATIONS)
@Measurement(iterations = MEASUREMENT_ITERATIONS)
@Fork(FORKS)
public class ArrayListBenchmark {

    private static final int LIST_SIZE = 100_000;

    private int e;
    private List<Integer> list1;
    private List<Integer> list2;

    @Setup(Level.Iteration)
    public void prepareList() {
        list1 = new ArrayList<>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE - 1; i++) {
            list1.add(i);
        }
        list2 = new ArrayList<>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE; i++) {
            list2.add(i);
        }
        e = LIST_SIZE;
    }

    /**
     * Вставка в конец
     */
    @Benchmark
    public void addLast() {
        list1.add(e);
    }

    /**
     * Вставка в начало
     */
    @Benchmark
    public void addFirst() {
        list1.add(0, e);
    }

    /**
     * Вставка в середину
     */
    @Benchmark
    public void addMiddle() {
        list1.add(LIST_SIZE / 2, e);
    }

    /**
     * Вставка в конец с ростом таблицы
     */
    @Benchmark
    public void addLastWithGrow() {
        list2.add(e);
    }

    /**
     * Вставка в начало с ростом таблицы
     */
    @Benchmark
    public void addFirstWithGrow() {
        list2.add(0, e);
    }

    /**
     * Вставка в середину с ростом таблицы
     */
    @Benchmark
    public void addMiddleWithGrow() {
        list2.add(LIST_SIZE / 2, e);
    }

    /**
     * Получение значения из конца
     */
    @Benchmark
    public Integer getLast() {
        return list2.get(LIST_SIZE - 1);
    }

    /**
     * Получение значения из начала
     */
    @Benchmark
    public Integer getFirst() {
        return list2.get(0);
    }

    /**
     * Получение значения из середины
     */
    @Benchmark
    public Integer getMiddle() {
        return list2.get(LIST_SIZE / 2);
    }
}
