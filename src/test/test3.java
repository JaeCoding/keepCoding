package test;

/**
 * @author: 彭文杰
 * @create: 2018-09-11 17:24
 **/
public class test3 {
    public static void main(String[] args) {
        int a = -2;
        int b = 5;
        Integer c = null;

        System.out.println(test());
    }

    abstract class a {

    }

    public static int test() {
        int i = 0;
        try {
            i++;
            throw new Exception("");
        } catch (Exception e) {
            return i++;
        }finally {
            i++;
        }
    }
}
