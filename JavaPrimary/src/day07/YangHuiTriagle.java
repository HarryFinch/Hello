package day07;

/**
 * @Description
 * @Author Pang Wenjian
 * @Date 9:30$ 2019/9/7$
 */

/*类中进行数组相关实践
1、杨辉三角
2、随机数数组
3、数组反转、复制
4、线性查找
5、二分法
 */
public class YangHuiTriagle {

    public static void main(String[] args) {
        YangHuiTriagle yt = new YangHuiTriagle();
        yt.YangHuiTriagle();
    }

    public void YangHuiTriagle() {
        int[][] triagle = new int[10][10];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= i; j++) {
                triagle[i][j] = 1;
            }
        }

        for (int i = 2; i < triagle.length; i++) {
            for (int j = 0; j < triagle[i].length; j++) {
                if (j == 0) {
                    triagle[i][j] = 1;
                } else {
                    triagle[i][j] = triagle[i - 1][j] + triagle[i - 1][j - 1];
                }
            }
        }

        for (int k = 0; k < 10; k++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(triagle[k][j] + "  ");
            }
            System.out.println();
        }
    }

    public void Rand() {
        int[] a = new int[6];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 30 + 1);
            //System.out.println(a[i]);
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if (a[i] == a[j]) {
                        i--;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }

    //数组反转
    public void arrayInversion() {
        String[] string = {"aa", "bb", "cc", "dd", "ee", "ff"};
        for (int i = 0; i < string.length / 2; i++) {//循环只需到中间
            String temp = string[i];
            string[i] = string[string.length - i - 1];
            string[string.length - i - 1] = temp;
        }
    }

    //数组的复制
    public void arrayCopy() {
        String[] string = {"aa", "bb", "cc", "dd", "ee", "ff"};
        String[] string1 = new String[string.length];
        for (int i = 0; i < string1.length; i++) {
            string1[i] = string[i];
        }
    }
    //线性查找
    public boolean linearResearch() {
        String[] string = {"aa", "bb", "cc", "dd", "ee", "ff"};
        String str = "cc";
        boolean flag = false ; //未找到指定字符，返回false
        for (int i = 0; i < string.length; i++) {
            if (str.equals(string[i])){
                System.out.println("Successful finding");
                flag = true  ; //找到目标字符，返回true
            }
        }
        return flag; //返回搜索结果
    }
    //二分法，前提所查找的数组有序
    public boolean dichotomy() {

        int[] array = {98 , 97 , 96 , 95 , 94 , 93 , 92 , 91 , 90} ;
        int head = 0; //起始点(初始的首索引)
        int end = array.length - 1 ; //终点（初始的尾索引）
        int mid = (head + end ) / 2; //中间点

        int goal = 93 ;

        boolean flag = true ;
        while(flag){
            if (array[mid] == goal){
                flag = false ;
                return false ;
            }else{
                if (array[mid] < goal ){
                    end = mid - 1;
                    mid = (head + end) / 2 ;
                }else{
                    head = mid + 1;
                    mid = (head + end ) / 2 ;
                }
            }
        }
        return flag;
    }
}
