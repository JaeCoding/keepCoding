package test;

import org.apache.commons.lang3.time.DurationFormatUtils;

/**
 * TODO 注释
 *
 * @author pengwenjie3
 * @date 2019/8/20
 * @since 1.8
 */
public class DurationFormatUtilsTest {
    public static void main(String[] args) throws InterruptedException {
        long open = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis() - open;
        String s = DurationFormatUtils.formatDuration(end, "HHH:mm:ss.SSS", true);
        System.out.println(end);

    }
}
