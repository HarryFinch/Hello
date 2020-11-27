package day16.manualOperation;

import day16.CustomException;

public class Manual {
    public static void main(String[] args) {
        Student student = new Student();
        try {
            student.regist(1000);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}


class Student {
    private int id;

    public void regist(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            //手动抛出异常对象
//            throw new RuntimeException("Input Wrong");
//            throw new Exception("Input Wrong");
            throw new CustomException("Input Wrong");
        }
    }
}