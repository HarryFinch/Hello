package day06;
/*
 * 数组属于引用数据类型，其元素也可以是引用数据类型
 * 一维数组的元素如果还是一维数组，该数组名为二位数组
 * */

public class ArrayTest {
    /*
     * 	一、数组概述
     * 		1、数组是多个相同数据类型数据按一定顺序排列的集合，
     * 			并通过编号的方式对数据进行统一管理
     * 		2、数组的相关概念：
     * 			>数组名
     * 			>元素
     *          >下标（索引）
     *          >下标（索引）
     *          >长度
     *      3、特点
     *          >数组是有序排列的
     *          >数组属于引用变量类型，数组的元素既可以是基本数据类型，也可以是引用数据类型
     *          >长度确定后不能更改
     *      4、分类
     *          >按照数组维度
     *          >按照数组元素数据类型
     */
    public void linearArray() {
		/*
			1、一维数组的声明和初始化
			2、如何调用数组的指定位置的元素
			3、如何获取数组长度
			4、如何遍历数组
			5、数组元素的默认初始值
			6、数组的内存解析
			6、数组的内存解析
		 */
        int[] ids; //Defined
        //初始化的方法
        ids = new int[4];
        //静态初始化方法：数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{1, 2, 3, 4};
        //动态初始化方法：数组的初始化和数组元素的赋值操作分开进行
        String[] name = new String[5];
		/*
		数组元素的默认初始化值
			1、数值类型默认值为零
			2、字符串型默认值为空
			3、布尔型默认值为false
			4、char类型：0或'\u0000' 。而非字符'0'
			5、引用数据类型默认值为null
		 */

    }

    //内存解析
    public void memoryParse() {
        /*
         * 1、内存结构在JVM中有规范
         * 2、JVM中有栈（stack）、堆（heap）、方法区（method area）
         * 3、方法区中有常量池、静态域
         * 4、从数组底层来看，没有多维数组概念
         * */
    }

    public void twoArray() {
        //二维数组的静态初始化方法
        int[][] array1 = new int[][]{{1, 2, 3,}, {4, 5}, {7, 8, 9}};
        int[][] array2 = {{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}}; //类型推断
        System.out.println(array1.length); //长度为3
        System.out.println(array1[1].length);//长度为2

        //二维数组的动态初始化方法
        String[][] string1 = new String[3][2];
        String[][] string2 = new String[3][];
        string2[1] = new String[4];  //第二行有四列

        System.out.println(array1[0][1]);

        //二维数组遍历，循环嵌套
    }

    //二位数组的使用
    public void useTwoArray() {

    	//int类型举例
        int[][] array2 = new int[4][3];
        System.out.println(array2);//[[I@1e643faf  数组地址 [[表示二维数组  I表示int类型  @后面是具体地址
        System.out.println(array2[0]); //[I@1e643faf 数组地址 [表示一维的    I表示是int类型   @后面是具体的地址
        System.out.println(array2[0][0]); //0 数组默认值

		//String类型举例
		String[][] strings = new String[3][5] ;
		System.out.println(strings) ; //[[Ljava.lang.String;@1e643faf 数组地址
		System.out.println(strings[0]); //[Ljava.lang.String;@6e8dacdf 数组地址
		System.out.println(strings[0][0]); //null  String类型数组默认值

		double array3[][] = new double[4][] ;
		System.out.println(array3[1]);  //输出null
		System.out.println(array3[1][0]); //空指针异常

        //length属性
        int[] arr ;
        arr = new int[4] ;
        System.out.println(arr.length);
        String[] string1 ;
        string1 = new String[9] ;
        System.out.println(string1.length);

    }
}
