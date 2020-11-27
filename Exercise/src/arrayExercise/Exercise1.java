package arrayExercise;

import org.junit.Test;

import java.lang.annotation.Target;

/*
 * @Author: Harold
 * @Date: 2020/3/27 10:53
 * @Description:
 *  创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
 */
public class Exercise1 {

    @Test
    public void test1() {
        int temp;
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * 30) + 1);
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr [ " + i + " ] = " + arr[i]);
        }
    }
}
