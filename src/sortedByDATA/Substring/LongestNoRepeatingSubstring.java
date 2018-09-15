package sortedByDATA.Substring;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-09-09 10:02
 **/

/**
 * 最长无重复字符子串 问题
 */
public class LongestNoRepeatingSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = longestSubstring(str);

        System.out.println(num);
    }


    public static int longestSubstring(String s) {
        //charPosition统计A中每种字符之前出现的位置
        Map<Character, Integer> positionOfChar = new HashMap<Character, Integer>();
        char[] strTocharArr = s.toCharArray();
        //preArr代表以s[i-1]结尾的情况下，最长无重复子串的长度
        int[] preArr = new int[s.length()];
        //从头到尾遍历str2charArr，统计出以每个字符为当前位置的向前最长无重复子串的长度
        for (int i = 0; i < s.length(); i++) {
            Integer lastPosOfChar = positionOfChar.get(strTocharArr[i]);
            if (lastPosOfChar == null) {//说明当前字符第一次出现
                //更新最长无重复子串的长度
                preArr[i] = i == 0 ? 1 : preArr[i - 1] + 1;
                //记录当前字符出现的位置
                positionOfChar.put(strTocharArr[i], i);
            } else {//当前字符不是第一次出现(既然不是第一次出现，那也不是在第一个位置),也就是之前出现过该字符
                //获取前一个字符最长无重复子串的长度
                int aPos = lastPosOfChar + 1;
                int unRepeatLen = preArr[i - 1];
                int bPos = i - unRepeatLen;
                if (aPos >= bPos) {
                    //当前位置的最长无重复子串长度
                    preArr[i] = i - aPos + 1;
                } else {
                    //当前位置的最长无重复子串长度
                    preArr[i] = i - bPos + 1;
                }
                //跟新当前字符出现的位置
                positionOfChar.put(strTocharArr[i], i);
            }
        }
        //遍历preArr,最大值即为所求
        int max = preArr[0];
        for (int i : preArr) if (i > max) max = i;
        return max;

    }
}
