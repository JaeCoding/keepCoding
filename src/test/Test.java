package test;

import java.awt.*;
import java.util.Arrays;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
//        String str = "1,2;3,5";
//        str = str.replace(";", " ").replace(",", " ");
//        String[] s1= str.split(" ",7);
//        System.out.println(str);
//        for (String s : s1
//             ) {
//            System.out.println(s);
//        }
        System.out.println(new Integer(1));
        Object[] arr = {1, 6, 3, 2};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+"");
        }
    }
}
