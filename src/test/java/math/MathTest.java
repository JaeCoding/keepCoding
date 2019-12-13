package math;

import dto.Teacher;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2019/12/5
 * @since 1.8
 */
public class MathTest {

    public static void main(String[] args) {



        String value = "43812.67930555555";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = DateUtil.getJavaDate(Double.parseDouble(value), false);
        System.out.println(sdf.format(date));
        System.out.println(new Date());
        System.out.println(date);
    }
}
