package day08NetProgram.TCP;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * @author Harold
 * @Date 2020/4/5
 * @Description :
 *  1、网络编程中有两个主要的问题
 *      1.1、如何精准定位网络中的另一台主机
 *      1.2、找到主机后，如何进行高效的数据传输
 *
 *  2、网络编程中的两个要素
 *      1.1、IP和端口号
 *      1.2、提供网络通信协议 TCP/IP 参考模型，分为四层
 *             --- 应用层 ---> 传输层 ---> 网络层 ---> 物理 + 数据链路层
 *
 *  3、通信要素1
 *      3.1、IP和端口号
 *          --- IP地址 ： 唯一的标识Internet上的主机
 *          --- 在Java中使用InetAddress类代表IP
 *          --- IP分类 ： IPv4 和 IPv6
 *          --- 万维网  和 局域网
 *      3.2、域名 ：www.baidu.com
 *
 *      3.3、实例化InetAddress两个方法
 *          --- getByName(String host)
 *          --- getLocalHost()
 *      3.4 两个常用方法
 *          getHostName()     获取对象域名
 *          getHostAddress()  获取对象IP地址
 *
 *      3.5 端口号 ： 标识正在计算机上运行的进程
 *              --- 不同的进程对应不同的端口号
 *              --- 被规定为16位的整数  0 ~ 65535
 *          3.5.1 端口的分类
 *              --- 公认端口 0-1023 被预先定义的服务通信占用，如HTTP占用端口80，FTP占用端口21， Telnet占用端口23
 *              --- 注册端口 1024-49151 分配给用户进程或应用程序 ， 如Tomcat占用8080端口，MySQL占用3306端口
 *              --- 动态/私有端口 49151-65535
 *          端口号和IP地址组合在一起构成一个socket
 *
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);

            InetAddress inetAddress2 = InetAddress.getByName("192.168.1.104");
            System.out.println(inetAddress2);

            //获取本地IP
            InetAddress inetAddress3 = InetAddress.getByName("127.0.0.1");
            InetAddress inetAddress4 = InetAddress.getLoopbackAddress();
            System.out.println(inetAddress3 );
            System.out.println(inetAddress4);

            //getHostName()、getHostAddress()
            System.out.println(inetAddress1.getHostName());
            System.out.println(inetAddress1.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
