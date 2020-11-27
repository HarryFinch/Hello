package aopImpl;

import org.springframework.stereotype.Component;

/**
 * @author Harold
 * @Date 2020/5/31
 * @Description : 接口的实现类，实现四则运算方法
 */

@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    int result = 0;

    @Override
    public int add(int i, int j) {
        result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        result = i - j;
        return result;
    }

    @Override
    public int multi(int i, int j) {
        result = i * j;
        return result;
    }

    @Override
    public int divided(int i, int j) {
        result = i / j;
        return result;
    }
}
