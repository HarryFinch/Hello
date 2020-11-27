package day07IOStream;

import org.junit.Test;

import java.io.*;

/*
 * @author Harold
 * @Date 2020/4/3
 * @Description : 处理流之二 ： 转换流  属于字符流
 *  1、InputStreamReader  ：将字节的输入流转换为字符的输入流
 *     OutputStreamWriter ：将字符的输出流转换为字节的输出流
 *  2、提供字节流与字符流之间的转换
 *  3、字符集
 *      3.1
 */
public class  InputStreamReaderDemo {

    @Test
    public void test1() {
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("dbcp.txt");
            //不指明字符集，就使用系统默认的字符集
            //字符集根据读取文件的字符集来确定
            isr = new InputStreamReader(fis, "utf-8");
            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    综合使用
     */
    @Test
    public void test2() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file1 = new File("dbcp.txt");
            File file2 = new File("dbcp_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis, "utf-8");
            osw = new OutputStreamWriter(fos, "gbk");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                //String str = new String(cbuf, 0, len);
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
