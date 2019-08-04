package sorted.dataStructure.arrays;


/**
 * 给int[] 加1  返回+1后的 int[]
 * <p>
 * 1.注意进位  和 9999的情况
 */
public class PlusOne {

    /**
     * 分为三种情况   1.此位不是9  2.此位是9 但不是在首位   3.是9 且在首位
     */
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int plus = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {//不是9的情况 加完直接结束
                digits[i]++;
                break;
            } else if (digits[i] + plus == 10 && i != 0) {//若是9 但不是首位9
                digits[i] = 0;
                continue;
            } else {//若是首位是9
                int[] digits1 = new int[len + 1];
                digits1[0] = 1;
                return digits1;
            }
        }
        return digits;
    }

    /**
     * 错误的解法 当数组很大时 无法转化为数值类型，long也不行
     */
    public static int[] plusOne__wrong(int[] digits) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        long result = Long.parseLong(sb.toString());//为啥9876543210
        result++;
        String re = Long.toString(result);
        int[] results = new int[re.length()];
        for (int i = 0; i < re.length(); i++) {
            results[i] = Integer.parseInt(String.valueOf(re.charAt(i)));
        }
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        arr = plusOne(arr);
        for (int num : arr
        ) {
            System.out.println(num + "");
        }
    }

}
