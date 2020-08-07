package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {

    public static void main(String[] args) {
        int start = 4639;
        int end = 18239;
        Date startTime = new Date();
        startTime.setTime(start);
        Date endTime = new Date();
        endTime.setTime(end);

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        System.out.println(msecToTime(start));

        System.out.println(formatter.format(end));
    }
    public static String secToTime(int seconds) {
        int hour = seconds / 3600;
        int minute = (seconds - hour * 3600) / 60;
        int second = (seconds - hour * 3600 - minute * 60);

        StringBuffer sb = new StringBuffer();
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分");
        }
        if (second > 0) {
            sb.append(second + "秒");
        }
        if (second == 0) {
            sb.append("<1秒");
        }
        return sb.toString();
    }
    /**
     * 将int类型数字转换成时分秒毫秒的格式数据
     *
     * @param time long类型的数据
     * @return HH:mm:ss.SSS
     * @author zero 2019/04/11
     */
    public static String msecToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        int millisecond = 0;
        if (time <= 0) {
            return "00:00:00.000";
        } else {
            second = time / 1000;
            minute = second / 60;
            millisecond = time % 1000;
            if (second < 60) {
                timeStr = "00:00:" + unitFormat(second) + "." + unitFormat2(millisecond);
            } else if (minute < 60) {
                second = second % 60;
                timeStr = "00:" + unitFormat(minute) + ":" + unitFormat(second) + "." + unitFormat2(millisecond);
            } else {// 数字>=3600 000的时候
                hour = minute / 60;
                minute = minute % 60;
                second = second - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second) + "."
                        + unitFormat2(millisecond);
            }
        }
        return timeStr;
    }
    public static String unitFormat(int i) {// 时分秒的格式转换
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }

    public static String unitFormat2(int i) {// 毫秒的格式转换
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "00" + Integer.toString(i);
        else if (i >= 10 && i < 100) {
            retStr = "0" + Integer.toString(i);
        } else
            retStr = "" + i;
        return retStr;
    }
}
