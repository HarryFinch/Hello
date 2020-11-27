package day04EnumerationAnnotation;

/*
 * @Author: Harold
 * @Date: 2020/3/22 18:48
 * @Description: 枚举类的使用
 *  1、理解：类的对象是有限、确定的，称此类为枚举类
 *  2、当需要定义一组常量是，强烈建议使用枚举类
 *  3、如果枚举类中只有一个对象，则可以作为单例模式
 *
 *  4、如何定义枚举类
 *      4.1 方式一 JDK5.0之前，自定义枚举类
 *      4.2 方式二 JDK5.0之后，可以使用enum
 *          使用枚举类定义的，默认继承java.lang.Enum
 *  5、Enum类中的常用方法
 *      values() 返回枚举型的对象数组，该方法可以很方便地遍历所有枚举值
 *      valueOf(String)可以把一个字符串转换为对应的枚举类对象。要求字符串必须是枚举对象的名字，如不是，会有运行时异常
 *      toString()返回当前枚举类对象常量的名称
 *  6、枚举类对象可以分别重写接口中的方法，实现不同的需求
 */
public class ClassSeason {
    public static void main(String[] args) {
        Season season = Season.AUTUMN;
        System.out.println(season.toString());
        System.out.println("****************************");
        EnumSeason[] enumSeasons = EnumSeason.values();
        for (int i = 0; i < enumSeasons.length; i++) {
            System.out.println(enumSeasons[i]);
        }
        System.out.println();
        //返回枚举类中与valueOf方法参数相同的对象
        EnumSeason winter = EnumSeason.valueOf("WINTER");
        System.out.println(winter);
        System.out.println(EnumSeason.AUTUMN);
    }
}

//方式一 ： 自定义枚举类
class Season {
    //声明Season对象属性
    private final String seasonName;
    private final String seasonDesc;

    //构造器私有化
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //构造对象
    public static final Season SPRING = new Season("Spring", "warm");
    public static final Season SUMMER = new Season("Summer", "Hot");
    public static final Season AUTUMN = new Season("Autumn", "cool");
    public static final Season WINTER = new Season("Winter", "cold");

    //其他诉求，获取枚举对象的属性


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

