package day07IOStream;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Harold
 * @Date 2020/4/5
 * @Description :
 */
public class FileUtilDemo {
    @Test
    public void testFileUtils() {
        File srcFile =new File("秦时明月.jpg");
        File destFile =new File("秦时明月4.jpg");
        try {
            FileUtils.copyFile(srcFile , destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
