package day14;

import org.junit.Test;

public class Review {
    @Test
    public void reviewerTest(){
        //数组继承Object
        int[] arr = new int[] {1,2,3};
        print(arr);//输出地址值
    }

    public void print(Object object) {
        System.out.println(object);
    }

}
