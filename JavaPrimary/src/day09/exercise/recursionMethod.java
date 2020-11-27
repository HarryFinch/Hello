package day09.exercise;
/*
    已知一个数列：f（0）=1 ，f（1） =4 ，f（n+2） = 2 * f（n+1） + f（n）
    求f（10）
 */
public class recursionMethod {

    public int f(int n) {
        if (n == 0 ){
            return 1 ;
        }else if (n == 1){
            return 4 ;
        }else{
            return 2 * f(n-1) + f(n-2) ;
        }
    }

    public int fibonacciArrays(int n) {
        if (n == 0){
            return 1 ;
        }else if (n == 1) {
            return 1 ;
        }else {
            return fibonacciArrays(n - 1 ) + fibonacciArrays(n -2 ) ;
        }
    }

    public static void main(String[] args) {
        recursionMethod r = new recursionMethod() ;
//        System.out.println(r.f(10) );
        System.out.println(r.fibonacciArrays(4));
    }
}
