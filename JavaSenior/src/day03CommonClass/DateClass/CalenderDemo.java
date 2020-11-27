package day03CommonClass.DateClass;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/*
 * @Author: Harold
 * @Date: 2020/3/22 14:28
 * @Description: Calendar类的使用
 *  1、Calenda类是个抽象类
 *  2、实例化的两种方式
 *      2.1 创建其子类GregorianCalendar类
 *      2.2 调用其静态方法getInstance也是构造子类对象
 *  3、常用方法
 *      3.1 get()  获取常用的日期信息
 *      3.2 set()
 *      3.3 add()
 *      3.4 getTime()
 *      3.5 setTime()
 */
public class CalenderDemo {
    @Test
    public void test1() {
        //1.实例化  创建其子类GregorianCalendar类   或
        // 调用其静态方法getInstance也是构造子类对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());
        //2.常用方法
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        calendar.set(Calendar.DAY_OF_MONTH , 22);

        calendar.add(Calendar.DAY_OF_MONTH , 2);
        System.out.println(calendar.getTime());

        //Calendar --> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.getTime());
    }
}
