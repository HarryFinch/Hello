package day07IOStream;

import org.junit.Test;

import java.io.*;

/*
 * @author Harold
 * @Date 2020/4/3
 * @Description : 其他流的使用
 *  1、标准的输入流
 *      System.in
 *  2、标准的输出流
 *      System.out
 *
 *  可以通过System类的 setIn 和 setOut 方法重新制定输入和输出的流
 *
 *  3、打印流
 *      3.1 提供了一系列重载的print和println方法
 *
 *  4、数据流 : 用于读取或写入基本数据类型的变量或字符串
 *      DataInputStream
 *
 *      DataOutputStream
 *
 *  注意点  : 读取顺序需要和写入的顺序保持一致
 */
public class StandStream {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                String data = br.readLine();
                if (data.equalsIgnoreCase("e") || data.equalsIgnoreCase("exit")) {
                    System.out.println("000000");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("text.txt"));
            dos.writeUTF("阿斯蒂芬");
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
            dos.writeInt(20);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("text.txt"));
            String s = dis.readUTF();
            boolean sex = dis.readBoolean();
            int age = dis.readInt();
            System.out.println(s);
            System.out.println(sex);
            System.out.println(age);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
