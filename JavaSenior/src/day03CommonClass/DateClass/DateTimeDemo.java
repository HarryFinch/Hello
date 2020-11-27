package day03CommonClass.DateClass;

import org.junit.Test;

import java.util.Date;

/*
 * @Author: Harold
 * @Date: 2020/3/21 17:22
 * @Description: JDK8 之前日期和时间的API测试
 */
public class DateTimeDemo {

    @Test
    public void test1() {

        //时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
    }


    /*
        java.util.Date
        java.sql.Date 继承util中Date类，对应着数据库中的日期类型变量
     */
    @Test
    public void test2() {
        //java.util.Date，构造器创建了一个对应当前时间的对象
        Date date1 = new Date();

        //toString显示当前时间
        System.out.println(date1.toString());

        //getTime()获取当前Date对象的（毫秒数）时间戳
        System.out.println(date1.getTime());

        //构造指定时间的Date对象，参数是一个毫秒证书long型
        Date date2 = new Date((long) (2E64-1L));
        System.out.println(date2.toString());
    }

    @Test
    public void test3() {
        // java.sql.Date
        java.sql.Date date = new java.sql.Date(313464654646413131L);
        System.out.println(date);
    }

    //java.util.Date 对象 转换为 java.sql.Date 对象
    @Test
    public void test4() {
/*        Date date = new java.sql.Date(1313131231231L);
        java.sql.Date date1 = (java.sql.Date)date;*/

        Date date1 = new Date();
        //构造一个java.sql.Date类对象，Date类对象.getTime方法获取的毫秒作为参数
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
    }

    public void test5() {
          /*
            util.Date类的有参构造器，带有偏移量。
            年份需要减1900
            月份需要减1
         */
        Date date1 = new Date(2020,9,8);
        System.out.println(date1); //Fri Oct 08 00:00:00 CST 3920
    }
}
