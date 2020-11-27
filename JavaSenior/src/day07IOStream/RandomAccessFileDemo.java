package day07IOStream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * @author Harold
 * @Date 2020/4/5
 * @Description : RandomAccessFile使用
 *
 *  1、RandomAccessFile
 *      直接继承Object类，
 *      实现了DataInput和DataOutput接口
 *      既可以作为输入流也可以作为输出流
 *
 *  2、如果RandomAccessFile作为输出流，写出的文件不存在，会自动创建
 *      如果写出到的文件存在，则从头覆盖源文件内容
 *
 */
public class RandomAccessFileDemo {

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("秦时明月.jpg"), "r");
            raf2 = new RandomAccessFile(new File("秦时明月3.jpg"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null) {
                    raf1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf1 != null) {
                    raf2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt", "rw");
            //将指针调到指定的位置
            raf1.seek(3);
            raf1.write("abc".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null) {
                    raf1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //实现“插入数据”的效果
    @Test
    public void test3() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt", "rw");
            //将指针调到指定的位置
            raf1.seek(3);

            //保存指针指定位置后的所有数据
            StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, len));
            }
            raf1.seek(3);
            raf1.write("abc".getBytes());

            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (raf1 != null) {
                    raf1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
