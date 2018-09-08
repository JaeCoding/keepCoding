package sortedByDATA.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: 彭文杰
 * @create: 2018-09-08 13:14
 *
 * 活动安排问题。活动时间有重叠，选出一个最大活动兼容集
 *
 * 思路：
 * 贪心算法： 先对活动以结束时间进行排序。从第一个开始，选择尽早结束的活动，这样能贪心地给后面活动留下更多时间。
 *          每次选择后，都可分为 已加入活动。和剩余活动子问题。
 *
 * 停止条件： 找到 输入k活动后 第一个结束的活动
 **/
public class ActivitySelector {

    public static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    public static List<Interval> greed(List<Interval> list) {
        //已按结束时间排好序，只要满足开始时间在k之后，就是所需要的。
        int n = list.size();
        List<Interval> max = new ArrayList<>();
        max.add(list.get(0));//第一次贪心选择
        int k = 0;//k表示的是对比的前者，也就是所寻找的
        for (int i = 1; i < n; i++) {
            if (list.get(i).start >= list.get(k).end) {//找到 开始时间满足在k的结束时间之后，并且排序后的结束时间是最优。
                max.add(list.get(i));
                k = i;//更新k，令存入者为前者
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));//添加0作为开头元素，辅助作用
        list.add(new Interval(3, 5));//添加0作为开头元素，辅助作用
        list.add(new Interval(0, 6));//添加0作为开头元素，辅助作用
        list.add(new Interval(5, 7));//添加0作为开头元素，辅助作用
        list.add(new Interval(3, 9));//添加0作为开头元素，辅助作用
        list.add(new Interval(5, 9));//添加0作为开头元素，辅助作用


        //根据结束时间排序
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });
        List<Interval> max = greed(list);
        for (Interval in : max
             ) {
            System.out.println(in.start + " "+ in.end);
        }
    }
}
