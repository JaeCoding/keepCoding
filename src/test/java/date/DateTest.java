package date;

import java.util.Date;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2019/10/13
 * @since 1.8
 */
public class DateTest {

    public static void main(String[] args) throws InterruptedException {
        Date before = new Date();
        Thread.sleep(1000L);
        Date after = null;
        // 早 < 晚 -1
        int i = before.compareTo(after);
        System.out.println(i);
    }
}
