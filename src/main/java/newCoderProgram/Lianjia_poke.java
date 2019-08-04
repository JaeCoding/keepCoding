package newCoderProgram;

import java.util.*;

/**
 * @Author: 彭文杰
 * @Date: Created in 2018/8/16 19:06
 * @Description :
 */
public class Lianjia_poke {


    //第二题
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] strs = string.split("");

        int[] count = new int[13];
        for (String str : strs
        ) {
            switch (str) {
                case "A":
                    str = "1";
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "2":
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "3":
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "4":
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "5":
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "6":
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "7":
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "8":
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "9":
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "T":
                    str = "10";
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "J":
                    str = "11";
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "Q":
                    str = "12";
                    count[Integer.parseInt(str)] += 1;
                    break;
                case "K":
                    str = "13";
                    count[Integer.parseInt(str)] += 1;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
        }
        int count1111 = 0;
        while (sum > 0) {
            //顺子
            for (int i = 0; i < count.length; i++) {
                int shunzi = 0;
                if (count[i] != 0) {
                    shunzi++;
                } else {
                    shunzi = 0;
                }
                if (shunzi >= 5) {
                    count1111++;
                    for (int j = shunzi, k = i; j > 0; j--, k--) {
                        count[k] -= 1;//减去顺子的个数
                    }
                }
                sum -= shunzi;
            }
            //四带二
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 4) {
                    count1111++;
                    count[i] -= 4;
                    for (int j = 0; j < 2; j++) {
                        if (count[j] == 1) {
                            count[j] -= 1;
                        }
                    }
                }
                sum -= 6;
            }
            //三带一
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 3) {
                    count1111++;
                    count[i] -= 3;
                    for (int j = 0; j < 1; j++) {
                        if (count[j] == 1) {
                            count[j] -= 1;
                        }
                    }
                }
                sum -= 4;
            }
            //对子
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 2) {
                    count1111++;
                    count[i] -= 2;
                    sum -= 2;
                }
            }
            //单牌
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 2) {
                    count1111++;
                    count[i] -= 2;
                    sum -= 1;
                }
            }
        }

    }
}
