package day07IOStream;

import org.junit.Test;

import java.io.File;

/*
 * @Author: Harold
 * @Date: 2020/3/26 17:19
 * @Description: File类的使用
 *一、File类简述
 *  1、File类的一个对象代表一个文件或者一个文件夹
 *  2、File类声明在java.io包下
 *  3、File类实例化
 *      相对路径 idea中
 *          --- 在单元测试方法中，相对于当前module的路径 ，
 *          --- 在main方法中，相对于当前工程的路径
 *      绝对路径
 *      路径分隔符  window \\    Unix: /
 *  4、三种构造方式。见test1测试
 *
 * 二、File常用方法
 *  File类的获取功能
 *   public String getAbsolutePath()：获取绝对路径
 *   public String getPath() ：获取路径
 *   public String getName() ：获取名称
 *   public String getParent()：获取上层文件目录路径。若无，返回null
 *   public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
 *   public long lastModified() ：获取最后一次的修改时间，毫秒值
 *
 *   public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
 *   public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
 *
 *  File类的重命名功能
 *   public boolean renameTo(File dest):把文件重命名为指定的文件路径
 *
 *  File类的判断功能
 *   public boolean isDirectory()：判断是否是文件目录
 *   public boolean isFile() ：判断是否是文件
 *   public boolean exists() ：判断是否存在
 *   public boolean canRead() ：判断是否可读
 *   public boolean canWrite() ：判断是否可写
 *   public boolean isHidden() ：判断是否隐藏
 *
 *  File类的创建功能
 *   public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
 *   public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。 如果此文件目录的上层目录不存在，也不创建。
 *   public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
        注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目 路径下。

 *  File类的删除功能
 *   public boolean delete()：删除文件或者文件夹
 *          删除注意事项： Java中的删除不走回收站。 要删除一个文件目录，
 *          请注意该文件目录内不能包含文件或者文件目录
 *
 */
public class IOStream {

    @Test
    public void test1() {
        //相对于当前module，相对路径和绝对路径
        //第一种初始化方式
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\PersonalProgram\\IDEA_Java_Program\\JavaNote\\JavaSenior\\hello.txt");
        System.out.println(file1);
        System.out.println(file2);

        //第二种初始化方式
        File file3 = new File("E:\\PersonalProgram\\IDEA_Java_Program", "JavaSenior");
        System.out.println(file3);

        //第三种初始化方式
        File file4 = new File(file3, "hello.txt");
        System.out.println(file4);
    }

    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\PersonalProgram\\IDEA_Java_Program\\IOExercise\\hi.txt");

        System.out.println("getAbsolutePath : " + file1.getAbsolutePath());
        System.out.println("getName         : " + file1.getName());
        System.out.println("getPath         : " + file1.getPath());
        System.out.println("getParent       : " + file1.getParent());
        System.out.println("length          : " + file1.length());
        System.out.println("lastModified    : " + file1.lastModified());

        System.out.println();
        System.out.println("getAbsolutePath : " + file2.getAbsolutePath());
        System.out.println("getName         : " + file2.getName());
        System.out.println("getPath         : " + file2.getPath());
        System.out.println("getParent       : " + file2.getParent());
        System.out.println("length          : " + file2.length());
        System.out.println("lastModified    : " + file2.lastModified());
    }

    @Test
    public void test3() {
        //要求文件真实存在，否则空指针异常
        File file1 = new File("E:\\PersonalProgram\\IDEA_Java_Program\\JavaNote\\JavaSenior");
        String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }
        //
        File[] files = file1.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    @Test
    public void test4() {
        File file1 = new File("hi.txt");
        File file2 = new File("E:\\PersonalProgram\\IDEA_Java_Program\\IOExercise");
        System.out.println("renameTo  : " + file1.renameTo(file2));
    }
}
