package day10;
/*
    JavaBean是一种Java语言写成的可重用组件
    所谓JavaBean是指符合如下标准的Java类：
        --类是公共的
        --有一个无参的公共构造器
        --有属性，且有对应的get、set方法
    用户可以使用JavaBean将功能、处理、值、数据库方法和其他任何可以用Java代码创造的对象进行打包，
    并且其他的开发者可以通过背部的JSP页面，Servlet、其他JavaBean、applet程序或者应用来使用这些对象。
    用户可以认为Javabean提供了一种随时复制和粘贴的功能，而不用关心任何改变
 */
public class JavaBean {

    public int Id ;
    public String name ;

    public JavaBean() {

    }
    public void setId(int i ) {
        Id = i ;
    }

    public int getId() {
        return Id ;
    }
}
