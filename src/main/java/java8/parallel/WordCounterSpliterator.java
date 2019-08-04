package java8.parallel;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Spliterator定义了并行流如何拆分它要遍历的数据
 */
class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    /**
     * 类似于普通的Iterator，因为它会按顺序一个一个使用Spliterator中的元素，
     * 并且如果还有其他元素要遍历就返回true。
     *
     * @param action 所遍历处理元素的 方法
     * @return 是否还有剩余元素
     */
    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    /**
     * Spliterator特有的方法
     * 它可以把一些元素划出去分给第二个Spliterator（由该方法返回），让它们两个并行处理。
     *
     * @return
     */
    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        //当前长度顺序处理，无需划分
        if (currentSize < 10) {
            return null;
        }
        for (int splitPos = currentSize / 2 + currentChar;
             splitPos < string.length(); splitPos++) {
            //划分为止处于空格才切分出去
            if (Character.isWhitespace(string.charAt(splitPos))) {
                Spliterator<Character> spliterator =
                        new WordCounterSpliterator(string.substring(currentChar,
                                splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    /**
     * @return 长度和当前遍历的位置的差
     */
    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    /**
     * 告诉框架这个Spliterator
     * ORDERED（顺序就是String中各个Character的次序）、
     * SIZED（estimatedSize方法的返回值是精确的）、
     * SUBSIZED（trySplit方法创建的其他Spliterator也有确切大小）、
     * NONNULL（String中不能有为 null 的 Character ） 和
     * IMMUTABLE （在解析 String 时不能再添加Character，因为String本身是一个不可变类）的
     */
    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}

