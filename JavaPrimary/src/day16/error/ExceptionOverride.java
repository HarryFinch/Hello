package day16.error;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
    方法重写的规则之一：
        子类重写方法抛出异常类型不大于父类被重写方法抛出的异常类型

 */
public class ExceptionOverride {

    public static void main(String[] args) {
        ExceptionOverride override = new ExceptionOverride();
        override.display(new SubClass());
    }

    public void display(SuperClass sup) {
        try {
            sup.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SuperClass {

    public void method() throws IOException {

    }
}


class SubClass extends SuperClass {

    public void method() throws FileNotFoundException {

    }
}
