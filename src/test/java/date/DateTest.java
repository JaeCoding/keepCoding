package date;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Test
 *
 * @author pengwenjie3
 * @date 2019/10/13
 * @since 1.8
 */
public class DateTest {

    public static void main(String[] args) throws InterruptedException {
//        Date before = new Date();
//        Thread.sleep(1000L);
//        Date after = null;
//        // 早 < 晚 -1
//        int i = before.compareTo(after);
//        System.out.println(i);

        HashSet<List<Integer>> lists = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
        list.remove(0);
        list.add(1);
        lists.add(list);

        System.out.println(1);
    }
}
