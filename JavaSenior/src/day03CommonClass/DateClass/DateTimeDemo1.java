package day03CommonClass.DateClass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Author: Harold
 * @Date: 2020/3/22 13:54
 * @Description:JDK1.8之前的日期时间API测试
 *  一、SimpleDateFormat
 *      1、格式化操作  日期 -----> 字符串
 *          1.1 SimpleDateFormat 实例化
 *          1.2 调用format方法对日期进行格式化
 *      2、解析操作  字符串 -----> 日期
 *
 *  二、Calender
 */
public class DateTimeDemo1 {
    @Test
    public void test1() {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat();
        Date date1 = new Date();
        //日期格式化
        String format1 = simpleDateFormat1.format(date1);
        System.out.println(format1);

        //日期解析,字符串格式固定
        String str1 = "19-3-22 下午14:02:30";
        try {
            Date date2 = simpleDateFormat1.parse(str1);
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //指定格式化的格式，调用带参的构造器
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy.MMMM.dd GGG hh:mm:aaa");
//        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM.dd hh:mm:ss");
        String format2 = simpleDateFormat2.format(date1);
        System.out.println(format2);
        try {
            System.out.println(simpleDateFormat2.parse("2020.三月.22 公元 02:09:下午"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*
    练习 ： 字符串 2020-03-22转换为Date
     */
    @Test
    public void testDateExercise() throws ParseException {
        String string1 = "2020-03-22";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(string1);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
        /*try {
            System.out.println(sdf1.parse(string1.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }
}
