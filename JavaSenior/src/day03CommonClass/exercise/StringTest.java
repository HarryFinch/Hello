package day03CommonClass.exercise;

/**
 * @Author: Harold
 * @Date: 2020/3/20 7:50
 * @Description:一道面试题
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");// good
        System.out.println(ex.ch); //best
    }
}
