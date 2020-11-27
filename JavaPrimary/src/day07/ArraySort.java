package day07;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description
 * @Author Pang Wenjian
 * @Date 2019-9-7$ 17:00$
 */
public class ArraySort {
    /*
     *0、算法五大特征
     *   ->输入
     *   ->输出
     *   ->有穷性
     *   ->确定性
     *   ->可行性
     *

     * 1、数组排序算法的优劣
         ->时间复杂度：分析关键字的比较次数和记录的移动次数
         ->空间复杂度：分析排序算法中需要多少辅助内存
         -> 稳定性：若两个记录A和B的关键字值相等，
                   但排序后A、B的小猴次序保持不变，这茬让那个这种排序算法是稳定的

     *2、十大内部排序算法（记得学习）
     *   （1）选择排序
     *       ->直接选择排序
     *       ->堆排序
     *   （2）交换排序(必会）
     *       ->冒泡排序
     *       ->快速排序
     *    (3)插入排序
     *       ->直接插入排序
     *       ->折半插入排序
     *       ->Shell排序1
     *   （4）归并排序
     *   （5）桶式排序
     *   （6）基数排序
     *
     */
    public void bubbleSort() {
        int[] array = {9, 12, 123, 7, 5, 3, 2, 10, 23};
        //Bubble Sort
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }
        }
        for (int k = 0; k < array.length; k++) {
            System.out.println(array[k] + "  ");
        }
    }
    //java.util.Arrays工具类
    public void arrayTool() {
        int[] array1 = {1 , 5, 3 ,4} ;
        int[] array2 = {3 , 2 , 1 ,4} ;
        System.out.println(Arrays.equals(array1 , array2)); ;
        System.out.println( Arrays.toString(array1) ) ;
        Arrays.fill(array2 , 5); //将数组中的元素全部替换成指定元素
        System.out.println( Arrays.toString(array2) ); //toString() 方法：遍历数组
        Arrays.sort(array1); //调用快排方法
        System.out.println( Arrays.toString( array1 ) );
        int[] array = {98 , 97 , 96 , 95 , 94 , 93 , 92 , 91 , 90} ;
        int index = Arrays.binarySearch(array , 94) ;
        System.out.println( index );
    }
    /*
    数组使用中的常见异常
        1、数组角标越界异常（ArrayIndexOutOfBoundsException)
            ->数组角标正常范围值[0 ， n-1 ] ，不在范围内均为异常
        2、空指针异常（NullPointerException)
            -> 数组值为null，或者是数组值为空、或者是数组未赋值

     */
}
