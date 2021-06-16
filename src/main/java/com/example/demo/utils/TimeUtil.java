package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/15 11:05 上午
 */
public class TimeUtil {

    /**
     * 获取下一个月的第一天，最后一天
     * @param current 当前日期
     * @param flag 0：第一天   1：最后一天
     * @return
     */
    public static String getServiceTime (Date current, int flag) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        calendar.add(Calendar.MONTH,1);
        // 下一个月的第一天
        if (0 == flag) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        } else {
            calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        return  pareseTime(calendar);
    }

    /**
     * 格式化日期
     *
     * @param calendar
     * @return
     */
    public static String pareseTime(Calendar calendar) {
        // 格式化日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(calendar.getTime());
        return dateStr;
    }

    /**
     * 格式化日期，00:00:00
     * @param calendar
     * @param day 0：代表当月的  1 代表下月
     * @return
     */
    private static Date parseDate( Calendar calendar,int day) {
        calendar.add(Calendar.DAY_OF_MONTH,day);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }
}
