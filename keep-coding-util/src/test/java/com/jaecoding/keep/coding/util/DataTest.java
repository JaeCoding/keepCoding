package com.jaecoding.keep.coding.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2020/2/23
 * @since 1.8
 */
public class DataTest {

    public static int daysBetweenDates(String date1,String date2){

        try{

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

            Calendar cal = Calendar.getInstance();

            cal.setTime(sdf.parse(date1));

            long time1 = cal.getTimeInMillis();

            cal.setTime(sdf.parse(date2));

            long time2 = cal.getTimeInMillis();

            long between_days=(time2-time1)/(1000*3600*24);

            return Math.abs(Integer.parseInt(String.valueOf(between_days)));

        }catch (Exception e){

        }
        return 1;

    }

    public static void main(String[] args) {

    }
}
