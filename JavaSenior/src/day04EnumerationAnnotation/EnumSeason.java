package day04EnumerationAnnotation;

/*
 * @Author: Harold
 * @Date: 2020/3/22 19:08
 * @Description:使用enum定义枚举类
 */

//方式二 ： 使用enum
interface Info{
    void show();
}


enum EnumSeason implements Info {
    //构造对象
    SPRING("Spring", "warm"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },

    SUMMER("Summer", "Hot"){
        @Override
        public void show() {
            System.out.println("夏天夏天悄悄过去");
        }
    },

    AUTUMN("Autumn", "cool"){
        @Override
        public void show() {
            System.out.println("一叶知秋");
        }
    },

    WINTER("Winter", "cold"){
        @Override
        public void show() {
            System.out.println("寒风彻骨");
        }
    };

    //声明Season对象属性
    private final String seasonName;
    private final String seasonDesc;

    //构造器私有化

    private EnumSeason(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //其他诉求，如 : 获取枚举对象的属性


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

