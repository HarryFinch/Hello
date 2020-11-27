package day05JavaSet.map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * @Author: Harold
 * @Date: 2020/3/25 9:10
 * @Description: Propeties
 */
public class PropetiesDemo {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pro = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pro.load(fis);
            System.out.println(pro.getProperty("name"));
            System.out.println(pro.getProperty("password"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
