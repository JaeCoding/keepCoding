package regex;

/**
 * TODO 注释
 *
 * @author pengwenjie3
 * @date 2019/9/4
 * @since 1.8
 */
public class Test1 {
    public static void main(String[] args) {
        String s = "vop质量部1331231243,asdasd，，，sadsadasdsad__dasd__sad,11，223,,,,，";
        String[] split = s.split(",|，");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        System.out.println(",".equals(","));

    }
}
