package leetcode;

/**
 * @author jae
 * <p>
 * 整数转罗马数字
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 */
public class Leetcode_12 {

    /**
     * 思路： 从大到小  依次查看符合情况 若符合（大于当前数） 减去对应数值  sb添加上对应罗马数
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        int[] base = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
                "V", "IV", "I"};
        StringBuilder s = new StringBuilder();
        int i = 0;//下标
        while (num > 0) {
            if (num >= base[i]) {//若符合（大于当前数） 减去对应数值  sb添加上对应罗马数
                s.append(str[i]);
                num -= base[i];
            } else {//注意!假如数为2400 一次只能减1000，而不要想着去算出是1000的倍数，减去两千。
                // 减去1000后，并不立即移位比较数（i++）而是开始下一循环，判断还比1000大吗，大的话再继续减。直到不比1000大了，i++移往下一位置。判断900
                i++;
            }
        }
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1234));
    }


}
