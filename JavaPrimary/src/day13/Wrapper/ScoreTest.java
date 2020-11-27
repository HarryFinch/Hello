package day13.Wrapper;

import java.util.Scanner;
import java.util.Vector;

/*
   利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），
   找出 最高分，并输出学生成绩等级。 提示：数组一旦创建，长度就固定不变，
   所以在创建数组前就需要知道它的 长度。而向量类java.util.Vector可以根据需要动态伸缩。

   创建Vector对象：Vector v=new Vector();
   给向量添加元素：v.addElement(Object obj);//obj必须是对象
   取出向量中的元素：Object  obj=v.elementAt(0);
   注意第一个元素的下标是0，返回值是Object类型的。
   计算向量的长度：v.size();
   若与最高分相差10分内：A等；
   20分内：B等；
   30分内：C等；
   其它：D等

 */
public class ScoreTest {

    public static void main(String[] args) {
        //1.实例化Scanner
        Scanner scanner = new Scanner(System.in);
        //2.常见Vector对象，Vector v=new Vector();
        Vector vector = new Vector();
        //3.通过循环（终止条件 输入负数），给Vector中添加数据  v.addElement(Object obj);
        int maxScore = 0;
        for (; ; ) {
            System.out.println("输入学生成绩，负数表示输入终止");
            int score = scanner.nextInt();
            if (score < 0) {
                break;
            }
            if (score > 100) {
                System.out.println("输入数据错误，重新输入");
                continue;
            }

            //JDK5.0之前得手动转换类型
            // Integer integerScore = new Integer(score);
            //vector.addElement(integerScore);

            //JDK5.0之后，增加了自动装箱
            vector.addElement(score);
            //4.获取学生成绩最大值
            if (maxScore < score) {
                maxScore = score;
            }
        }

        //5.遍历Vector，找到最大成绩，得到学生等级
        char level;
        for (int i = 0; i < vector.size(); i++) {
            Object object = vector.elementAt(i);
            //JDK5.0之前
//            Integer integerScore = (Integer) object;
//            int score = integerScore.intValue();

            //JDK5.0之后
            int score = (int)object ;

            if (maxScore - score < 10) {
                level = 'A';
            } else if (maxScore - score < 20) {
                level = 'B';
            } else if (maxScore - score < 3) {
                level = 'C';
            } else {
                level = 'D';
            }
            System.out.println("Student - " + i + "score is " + score + ",level is " + level );
        }
    }
}
