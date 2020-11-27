package aop;

/**
 * @author Harold
 * @Date 2020/5/31
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
//        ArithmeticCalculator  arithmeticCalculator = null;
//        arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();
//
//        arithmeticCalculator.add(1, 2);
//        arithmeticCalculator.multi(1, 2);

        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLogging();

        int result = proxy.add(1, 2);
        System.out.println("add result --> " + result + "\n" );
        result = proxy.divided(4, 2);
        System.out.println("divided result ---> " + result + "\n" );

    }

}
