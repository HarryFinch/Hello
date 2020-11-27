package day07IOStream;

import org.junit.Test;

import java.io.*;

/*
 * @author Harold
 * @Date 2020/4/2
 * @Description : IO流
 * 一、流的分类
 *  1、操作数据单位 ： 字节流、字符流
 *  2、数据的流向 ： 输入流、输出流
 *  3、流的角色 ： 字节流、处理流
 * 二、流的体系结构
 *  1、 抽象基类             节点流（文件流）          缓冲流（处理流的一种）
 *      InputStream         FileInputStream         BufferedInputStream
 *      OutputStream        FileOutputStream        BufferedOutputStream
 *      Reader              FileReader              BufferedReader
 *      Writer              FileWriter              BufferedWriter
 *  2、read()方法，返回一个字符，到达文件末尾，返回-1
 *     异常处理 ： 为了保证流资源以ID那个可以执行关闭操作，需要使用try-catch-finally
 *      读入文件一定要存在，否则会包FileNotFoundException
 *  3、字符流不能处理字节数据，只能处理字符文件
 */
public class FileReaderWriter {

    public static void main(String[] args) {
        //相对于工程开始
        File file1 = new File("stream\\hello.txt");
    }

    @Test
    public void testFileReaderFileWriter() {
        //指明读取和写入的文件
        FileReader fileReader1 = null;
        FileWriter fileWriter1 = null;
        try {
            File fileReader = new File("hello1.txt");
            File fileWriter = new File("hello2.txt");

            //创建输入流和输出流的对象
            fileReader1 = new FileReader(fileReader);
            fileWriter1 = new FileWriter(fileWriter);

            //读取文件和写入操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader1.read(cbuf)) != -1) {
                fileWriter1.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源
            try {
                fileWriter1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileReader1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /*数据从内存写到硬盘
        FileWriter(File , boolean)
            File  文件路径
            boolean
                false  不在原有文件上进行追加(默认值)
                true   在原有文件上进行追加，不会覆盖原有文件
            文件不存在，在创造对应文件，
     */
    @Test
    public void testFileWriter() {
        FileWriter fileWriter = null;
        //提供FileWriter对象，用于数据写出
        try {
            File file = new File("hello1.txt");
            fileWriter = new FileWriter(file, true);
            fileWriter.write("I have a dream!\n");
            fileWriter.write("You need to have a dream!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //对read()操作升级，重载方法的使用
    @Test
    public void testReader1() {
        //硬盘中有对应的文件
        File file = new File("hello.txt");
        FileReader fileReader = null;
        try {
            //流的实例化
            fileReader = new FileReader(file);
            //读入的操作
            char[] cbuf = new char[5];
            int len;
            //循环文件数据
            while ((len = fileReader.read(cbuf)) != -1) {
                //每次循环len长度，避免最后一次出现问题
                for (int i = 0; i < len; i++) {
                    System.out.println(cbuf[i]);
                }
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    //资源的关闭
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader() {
        //实例化File类对象，指明要操作的文件
        File file = new File("hello.txt");
        FileReader fileReader = null;
        try {
            //提供具体的流
            fileReader = new FileReader(file);
            //数据的读取，返回读取的字符，末尾返回 -1
            //方式一
/*        int data = fileReader.read();
        while(data != -1) {
            System.out.print((char) data);
            data = fileReader.read();
        }*/
            //方式二  针对方式一的一种修改，语法上的修改，关闭写到了循环条件里
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
