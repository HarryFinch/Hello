package day07IOStream;

import org.junit.Test;

import java.io.*;

/*
 * @author Harold
` * @Date 2020/4/5
 * @Description : 对象流的使用
 *  1、ObjectInputStream 和 ObjectOutputStream
 *      用于存储和读取基本数据类型数据或对象的处理流。
 *      它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来
 *  2、序列化过程
 *      将内存中的Java对象保存到磁盘中或者通过网络传输出去
 *      使用ObjectOutputStream实现
 *      见testObjectOutputStream()
 *  序列化的要求，见ObjectStreamExerPerson类
 *
 *  3、反序列化 ： 将磁盘中的文件还原为内存中的一个Java对象
 *      使用ObjectInputStream来实现
 *      见testObjectInputStream()
 */
public class ObjectInputOutputStream {
    //序列化过程
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我试试好使不"));
            oos.flush();

            oos.writeObject(new ObjectStreamExerPerson("阿斯蒂芬", 20));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object object = ois.readObject();
            String str = (String) object;
            System.out.println(str);

            ObjectStreamExerPerson person = (ObjectStreamExerPerson) ois.readObject();
            System.out.println(person);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
