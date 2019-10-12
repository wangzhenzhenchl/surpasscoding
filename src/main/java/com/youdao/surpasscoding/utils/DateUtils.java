package com.youdao.surpasscoding.utils;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

/**
 * @Description
 * @Author wzz
 * @Date 2019/10/12 15:58
 */
public class DateUtils {

    public static String getCurrentDate(String aFormat) {
        String tDate = new SimpleDateFormat(aFormat).format(new java.util.Date(System.currentTimeMillis()));
        return tDate;
    }

    public static String getCurrentDate() {
        return DateUtils.getCurrentDate("yyyyMMdd");
    }

    public static String getCurrentTime() {
        return DateUtils.getCurrentDate("HHmmss");
    }

    public static String getCurrentDateAndTime() {
        return DateUtils.getCurrentDate("yyyyMMddHHmmss");
    }

    public static String getCurrentDateAndTimeFormat() {
        return DateUtils.getCurrentDate("yyyy-MM-dd HH:mm:ss");
    }


    @Test
    public static void main(String[] args) {

        System.out.println(getCurrentDate());
        System.out.println(getCurrentTime());
        System.out.println(getCurrentDateAndTime());
        System.out.println(getCurrentDateAndTimeFormat());
    }

}