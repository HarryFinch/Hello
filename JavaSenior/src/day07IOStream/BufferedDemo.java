package day07IOStream;

import org.junit.Test;

import java.io.*;

/*
 * @author Harold
 * @Date 2020/4/3
 * @Description :  处理流之一 缓冲流的使用
 *  BufferedInputStream
 *  BufferedOutputStream
 *      内部提供了一个缓冲区
 *      flush方法刷新缓冲区，把缓冲区当前的数据都写出
 *  BufferedReader
 *  BufferedWriter
 */

public class BufferedDemo {

    @Test
    public void BufferedStreamTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //创建文件
            File srcFile = new File("秦时明月.jpg");
            File destFile = new File("秦时明月2.jpg");

            //创造文件流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //创建处理流（缓冲流）
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //复制的细节 ： 读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
//                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源，先关闭外层的流，再关闭内层的流
            //关闭外层的同时，内层流也会自动关闭
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /*
    BufferedReader 和 BufferedWriter的使用
     */
    @Test
    public void testBufferedReaderWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello2.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello3.ext")));
            //读写操作，方式一 ： 使用char数组
            char[] cbuf = new char[1024];
            int len;
            while ((len = br.read(cbuf)) != -1) {
                bw.write(cbuf, 0, len);
            }
            //方式二 ： 使用String，
            // 方法忽略换行符，可以手动添加 \n 换行
            // 或者使用newLine()方法
            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);
                bw.newLine();
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
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




























