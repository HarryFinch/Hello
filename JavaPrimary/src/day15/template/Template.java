package day15.template;

/*
    模版方法的设计模式：通用性
    抽象类的应用：模版方法的设计模式
 */
public class Template {
}

abstract class TemplateDemo {

    //计算某段代码执行所花费的时间
    public void spendTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.println("time : " + (end - start));
    }

    public abstract void code();
}

class SubTemplate extends TemplateDemo {
    @Override
    public void code() {
        for (int i = 2; i < 1000; i++) {
            boolean isFlag = true ;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                }
            }
            if (isFlag) {
                System.out.println(i);
            }
        }
    }
}