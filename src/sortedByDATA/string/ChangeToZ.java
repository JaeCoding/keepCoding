package sortedByDATA.string;

public class ChangeToZ {
    public static void main(String[] args) {
        String st = convert1("ABCDEFGHIJK", 4);
        System.out.println(st);
    }


    /**
     * z 字变换
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int i = 0;//外层大循环，表示每一行的循环
        int j = 0;
        int gap1 = 2 * numRows - 3;//前半段gap
        int gap2; //后半段gap
        int gap = 0; //真实的gap参考，每次-2，  在头尾部分为特殊值
        int flag = 1; //1表示在前半段，-1表示在后半段
        StringBuffer sb = new StringBuffer();
        while (i < numRows) {
            if (i == 0 || i == numRows - 1) {
                gap = 2 * numRows - 3;
                while (j < len) {
                    sb.append(s.charAt(j));
                    j += (gap + 1);
                }
            } else {//处于中间，要判断下在前面还是后面
                gap1 = gap;//左
                gap2 = 2 * i - 1;//右
                while (j < len) {
                    sb.append(s.charAt(j));
                    j = flag == 1 ? (j + gap1 + 1) : (j + gap2 + 1);
                    flag *= -1;
                }
            }
            gap = gap - 2 > 0 ? gap - 2 : (2 * numRows - 3);
            i++;
            j = i;
            flag = 1;
        }
        return String.valueOf(sb);
    }

    public static String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

}
