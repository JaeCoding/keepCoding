package com.jaecoding.keep.coding.util.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * 切面类 多为辅助功能类
 *
 * @author Jae
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    /**
     * 切点设定为：Performance.perform方法
     *
     * @param trackNumber 切面方法 会用到的 trackNumber参数
     */
    @Pointcut(
            "execution(* com.jaecoding.keep.coding.util.aop.soundsystem.CompactDisc.play(int))" +
                    "&& args(trackNumber)")
    public void trackPlayed(int trackNumber) {

    }

    /**
     * 在切点前织入
     */
    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber)
                ? trackCounts.get(trackNumber) : 0;
    }
}