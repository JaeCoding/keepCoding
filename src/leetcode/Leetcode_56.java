package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。

 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2:

 输入: [[1,4],[4,5]]
 输出: [[1,5]]
 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

 *思路：
 * leetcode提供的区间是个对象结构体， 一般oj提供的是数字
 * 需要将结构体排序，规则：根据start排序 构造comparable函数
 *
 * 排序后：第一个直接加入集合，然后从第二个开始对给区间集一个一个的遍历比较，
 * 遍历添加分为 重叠 和 不重叠 两种情况
 * 不重叠：直接添加
 * 重叠： 分为两种情况  判断前者比较者的end 与 当前选择者的 end 哪个大  比如分为 1-5与2-3（还是1-5）、  1-5与2-7比较（end更新为1-7）
 */
public class Leetcode_56 {

    /**
     * 题目提供的 区间结构体
     */
    public class Interval {
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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        //用自定义方法排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval listPre = list.get(list.size() - 1);
            Interval intervalNow = intervals.get(i);
            //不重叠 直接添加
            if (intervalNow.start > listPre.end) {
                list.add(intervalNow);
            } else if (intervalNow.start <= listPre.end && intervalNow.end > listPre.end) {//重叠 即 startNow <= endPre 则更新上一个的end为现在的end
                listPre.end = intervalNow.end;
                list.set(list.size() - 1, listPre);
            } else {//在内部的情况，什么也不做
                continue;
            }
        }
        return list;

    }



    public static void main(String[] args) {

    }
}
