package day03CommonClass.DateClass;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/*
 * @Author: Harold
 * @Date: 2020/3/22 14:45
 * @Description: JDK8 中时间API
 *  1. LocalDate
 *  2. LocalTime
 *  3. LocalDateTime  相对来说，使用的多些
 */
public class JDK8DateTime {

    //LocalDate、LocalTime、LocalDateTime
    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //设置指定的年月日时分秒，而且没有偏移量
        LocalDateTime.of(2020 , 3 , 22 , 15,0,0);


        //localDateTime类中的getXxxx方法可以获取到很多日期、时间，而日期没有偏移量
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());

        //不可变性，对日期、时间进行设置
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //时间日期进行 加、减 操作
        localDateTime.plusDays(1);
        localDateTime.plusHours(1);

        localDateTime.minusDays(1);
        localDateTime.minusHours(1);
    }


    //Instant瞬时点
    @Test
    public void test2() {
        //本初子午线时间，世界标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //设置为东八区时间，也就是中国的时区
        OffsetDateTime odt1 = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt1);

        //获取距1970.1.1 0.0.0的毫秒数
        System.out.println(instant.toEpochMilli());
        //通过给定的毫秒数，获取Instant实例
        Instant.ofEpochMilli(1331313131131L);
    }


    //DateTimeFormatter: 格式化或解析时间、日期
    @Test
    public void test3() {
        //方式一 预定义的标准格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String string = dateTimeFormatter.format(localDateTime);
        System.out.println(string); //2020-03-22T15:27:48.061

        TemporalAccessor parse = dateTimeFormatter.parse("2020-03-22T15:27:48.061");
        System.out.println(parse);

        //方式二 本地化相关的格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String format = formatter1.format(localDateTime);
        System.out.println(format);

        DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter formatter5 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        String format1 = formatter4.format(LocalDate.now());
        String format2 = formatter5.format(LocalDate.now());
        System.out.println(format1);
        System.out.println(format2);


        //方式三 自定义格式
        //格式化
        DateTimeFormatter dateformat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String string1 = dateformat1.format(LocalDateTime.now());
        System.out.println(string1);
        //解析
        TemporalAccessor parse1 = dateformat1.parse("2020-3-22 15:40:00");
        System.out.println(parse1);
    }
}
