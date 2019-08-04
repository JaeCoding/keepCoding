package java8.parallel;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterTest {

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }

    public static void main(String[] args) {

        final String SENTENCE =
                " Nel mezzo del cammin di nostra vita " +
                        "mi ritrovai in una selva oscura" +
                        " ché la dritta via era smarrita ";
        //基本流只有int double long ,map转化为对象流
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);


        System.out.println("Found " + countWords(stream) + " words");
        //直接使用并行流  结果会出错，因为其在字母的中间进行拆分了，所以要自己设计分割器
        System.out.println("Found " + countWords(stream.parallel()) + " words");

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        /*
        StreamSupport.stream工厂方法
        参数1：划分规则
        参数2: 开启并行流
         */
        Stream<Character> stream3 = StreamSupport.stream(spliterator, true);

        int a = 10;
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };

    }
}
