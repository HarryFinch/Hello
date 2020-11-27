package day07IOStream;

import org.junit.Test;

import java.io.*;

/*
 * @author Harold
 * @Date 2020/4/3
 * @Description : 测试FileInputStream 和FileOutputSteam
 *
 * 结论 ：
 *      1、对于文本文件(txt,java,c,cpp)，使用字符流处理
 *      2、对于非文本文件(jpg,doc,音频、视频)，使用字节流处理
 *
 */
public class FileInputOutputStream {

    //使用FileInputOutputStream处理文本文件可能出现乱码
    @Test
    public void testFileInputStream() {

        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");

            fis = new FileInputStream(file);

            //读取数据
            byte[] buffer = new byte[5];

            int len;

            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //实现对图片的复制
    @Test
    public void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("秦时明月.jpg");
            File destFile = new File("秦时明月1.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //指定路径下文件的复制
    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();
        String src = "秦时明月.jpg";
        String dest = "秦时明月1.jpg";
        copyFile(src , dest);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
