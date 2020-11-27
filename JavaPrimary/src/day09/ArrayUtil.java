package day09;

/*
    自定义数组的工具类
 */
public class ArrayUtil {

    //求数组的最大值
    public int getMaxValue(int[] a) {
        int MAX = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > MAX) {
                MAX = a[i];
            }
        }
        return MAX;
    }

    //求数组的最小值
    public int getMinValue(int[] a) {
        int MIN = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < MIN) {
                MIN = a[i];
            }
        }
        return MIN;
    }

    //求数组的总和
    public int getSumValue(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    //求数组的平均值
    public double getAverageValue(int[] a) {
        return getSumValue(a) / a.length;
    }

    //反转数组
    public void arrayReverse(int[] a) {
        /*
        for (int i = 0 ; i < a.length / 2 ; i++) {
            int temp = a[i] ;
            a[i] = a[a.length -i -1] ;
            a[a.length - i - 1 ] = temp ;
        }
        */

        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

        }
    }

    //复制数组
    public int[] copyArray(int[] a) {
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    //数组排序
    public void arraySort(int[] a) {
        int temp;
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length - i - 1; j++) {

                if (a[j] > a[j + 1]) {

                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }
    }

    //遍历数组
    public void arrayPrint(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " , ");
        }
    }

    public int getIndex(int[] a, int dest) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] == dest) {
                return i;
            }
        }
        return -1;
    }
}
