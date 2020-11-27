package aop;

/**
 * @author Harold
 * @Date 2020/5/31
 * @Description :
 *      在每个方法中添加日志信息，但是一旦日志信息发生变化，需要全部修改，比较麻烦
 */
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

    int result = 0;

    @Override
    public int add(int i, int j) {
        System.out.println("The method add begins with [" + i + "," + j + "]");
        result = i + j;
        System.out.println("The method add end with " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("The method sub begins with [" + i + "," + j + "]");
        result = i - j;
        System.out.println("The method sub end with " + result);
        return result;
    }

    @Override
    public int multi(int i, int j) {
        System.out.println("The method multi begins with [" + i + "," + j + "]");
        result = i * j;
        System.out.println("The method multi end with " + result);
        return result;
    }

    @Override
    public int divided(int i, int j) {
        System.out.println("The method divided begins with [" + i + "," + j + "]");
        result = i / j;
        System.out.println("The method divide end with " + result);
        return result;
    }
}
