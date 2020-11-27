package day03;

/*
for循环结构的使用
一、循环结构的4个要素
    1、初始化条件
    2、循环条件 ——>布尔类型
    3、循环体
    4、迭代条件
二、质数筛选
 */
public class CirculationTest {

    public void test() {
        //练习
        int num = 1;
        for (System.out.println('a'); num <= 3; System.out.println('c'), num++) {
            System.out.println('b');
        }
    }

    public void primerNumber() {
        long a = System.currentTimeMillis();
        int count = 0;
        label:
        for (int i = 2; i <= 100000; i++) {

            for (int j = 2; j < Math.sqrt(i); j++) {

                if (i % j == 0) {
                    continue label;
                }

            }
            count++;
        }

        long b = System.currentTimeMillis();
        System.out.println(count);
        System.out.println("Time" + (b - a));
    }

    public static void main(String[] args) {
        CirculationTest circulationTest = new CirculationTest() ;
        circulationTest.primerNumber();
    }
}
