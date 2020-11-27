package day08NetProgram.UDP;

import java.net.URL;

/*
 * @author Harold
 * @Date 2020/4/10
 * @Description : URL 的网络编程
 *  1、URL ： 统一资源定位符，对应着互联网上的某一资源地址
 *  2、格式
 *      http://localhost:8080/examples/文件
 *  3、常用方法
 *       public String getProtocol( ) 获取该URL的协议名
 *       public String getHost( ) 获取该URL的主机名
 *       public String getPort( ) 获取该URL的端口号
 *       public String getPath( ) 获取该URL的文件路径
 *       public String getFile( ) 获取该URL的文件名
 *       public String getQuery( ) 获取该URL的查询名
 */
public class URLDemo {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/%E7%A7%A6%E6%97%B6%E6%98%8E%E6%9C%88.jpg");
//            public String getProtocol( ) 获取该URL的协议名
            System.out.println(url.getProtocol());
//            public String getHost( ) 获取该URL的主机名
            System.out.println(url.getHost());
//            public String getPort( ) 获取该URL的端口号
            System.out.println(url.getPort());
//            public String getPath( ) 获取该URL的文件路径
            System.out.println(url.getPath());
//            public String getFile( ) 获取该URL的文件名
            System.out.println(url.getFile());
//            public String getQuery( ) 获取该URL的查询名
            System.out.println(url.getQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
