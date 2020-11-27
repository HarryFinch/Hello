package day10;

public class ValueTransfer {
    public static void main(String[] args) {
        String s1 = "Hello" ;
        ValueTransfer valueTransfer = new ValueTransfer() ;
        valueTransfer.change(s1);
        System.out.println(s1);
    }

    public void change(String s) {
        s = "Hi ~~~";
    }
}
