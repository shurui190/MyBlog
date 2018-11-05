package com.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by shurui on 2018/10/21.
 */

public class TimeFormatUtil {


    public static String getFormatDatetime(Date date) {
        if (date == null) {
            return "无";
        }

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

    }

    public static Date getFormatDatetime(String date) {
        return format("yyyy-MM-dd HH:mm:ss", date);
    }

    private static Date format(String formation, String date) {
        if (date == null || date.isEmpty() || date.equals("无")) {
            return null;
        }
        Date formatDate = null;
        DateFormat dateFormat = new SimpleDateFormat(formation);

        try {
            formatDate = dateFormat.parse(date);
        } catch (ParseException e) {
            switch (formation) {
                case "yyyy-MM-dd HH:mm:ss":
                   System.out.println("时间格式错误，应为yyyy-MM-dd HH:mm:ss");
                default:
                	 System.out.println("时间格式错误，应为yyyy-MM-dd");
            }
        }
        return formatDate;
    }
}
