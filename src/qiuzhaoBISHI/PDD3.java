package qiuzhaoBISHI;

import java.util.*;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 **/
public class PDD3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //产品个数
        int m = sc.nextInt(); //优惠卷个数
        int[] productArr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int aa = sc.nextInt();
            productArr[i] = aa;
            sum += aa;
        }
        Arrays.sort(productArr);

        int[] pricesTop = new int[m];
        int[] discount = new int[m];
        boolean[] flag = new boolean[m];
        for (int i = 0; i < m; i++) {
            int price = sc.nextInt();
            int dis = sc.nextInt();
            pricesTop[i] = price;
            discount[i] = dis;
            flag[i] = true;
        }

        int discountResult = 0;//总的 可使用折扣
        for (int i = n-1; i >= 0; i--) {
            int maxDis = 0;
            for (int j = 0; j < m; j++) {
                if (productArr[i] >= pricesTop[j] && flag[j]) {//若 产品价格 大于等于 优惠卷限制，且此优惠卷未使用
                    maxDis = Math.max(maxDis, discount[j]);
                }
            }
            for (int j = 0; j < m; j++) {
                if (discount[j] == maxDis) { //找到 最大折扣的优惠卷 标为已使用过
                    flag[j] = false;
                }
            }
            discountResult += maxDis;
        }
        int out = sum - discountResult;
        System.out.println(out);
    }
}
