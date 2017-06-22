# jmh
Benchmark основных операций в базовых классах с помощью JMH

ArrayList vs LinkedList
- вставка значения в конец списка
- вставка значения в начало списка
- вставка значения в середину списка
- получение значения из конца списка
- получение значения из начала списка
- получение значения из середины списка

HashMap vs TreeMap
- вставка ключ-значение
- получение значения по ключу

Запуск теста:
```
git clone https://github.com/msamoylych/jmh.git
cd jmh
mvn clean package
java -jar target\jmh.jar -jvmArgs "-Xms1G -Xmx1G"
```

Результат для Intel(R) Core(TM) i7-4700MQ CPU @ 2.40GHz:

```
Benchmark                             Mode  Cnt       Score       Error  Units
ArrayListBenchmark.addFirst             ss  100   60765,110 ?  3289,449  ns/op
ArrayListBenchmark.addFirstWithGrow     ss  100  188932,740 ? 20909,644  ns/op
ArrayListBenchmark.addLast              ss  100    2172,530 ?   198,475  ns/op
ArrayListBenchmark.addLastWithGrow      ss  100  140885,880 ? 18135,679  ns/op
ArrayListBenchmark.addMiddle            ss  100   35495,240 ?  2265,669  ns/op
ArrayListBenchmark.addMiddleWithGrow    ss  100  155934,950 ? 24135,195  ns/op
ArrayListBenchmark.getFirst             ss  100    3271,540 ?   483,624  ns/op
ArrayListBenchmark.getLast              ss  100    2463,330 ?   277,437  ns/op
ArrayListBenchmark.getMiddle            ss  100    4182,440 ?   456,135  ns/op
LinkedListBenchmark.addFirst            ss  100    4849,580 ?   492,284  ns/op
LinkedListBenchmark.addLast             ss  100    2065,620 ?   232,359  ns/op
LinkedListBenchmark.addMiddle           ss  100  120841,800 ? 13909,459  ns/op
LinkedListBenchmark.getFirst            ss  100    4610,110 ?   321,066  ns/op
LinkedListBenchmark.getLast             ss  100    3763,300 ?   273,486  ns/op
LinkedListBenchmark.getMiddle           ss  100  132970,120 ? 14069,491  ns/op
HashMapBenchmark.get                    ss  100    5576,600 ?   631,705  ns/op
HashMapBenchmark.put                    ss  100    3066,290 ?   175,006  ns/op
HashMapBenchmark.putWithResize          ss  100  882820,630 ? 43866,334  ns/op
TreeMapBenchmark.get                    ss  100    4729,790 ?   583,769  ns/op
TreeMapBenchmark.put                    ss  100    3023,480 ?   437,909  ns/op
```

*Данные значения стоит рассматривать только как относительные величины*
