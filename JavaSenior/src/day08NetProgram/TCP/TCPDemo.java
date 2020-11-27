package day08NetProgram.TCP;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * @author Harold
 * @Date 2020/4/10
 * @Description : 实现TCP的网络通信协议
 *
 *  例1、客户端发送信息至服务端，服务端将其输出在控制台上
 *
 */
public class TCPDemo {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //创建Socket对象，指明服务器端的IP和端口号
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8899);

            //创建输出流
            outputStream = socket.getOutputStream();
            outputStream.write("Hello Server".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            //创建ServerSocket ， 指明端口号
            serverSocket = new ServerSocket(8899);
            //表示接受来自客户端的socket
            accept = serverSocket.accept();
            //获取一个输入流
            inputStream = accept.getInputStream();

            //可能造成乱码
/*        byte[] buffer = new byte[20];
        int len ;
        while ((len = inputStream.read(buffer)) != -1) {
            String str = new String(buffer , 0 , len);
        }*/

            //读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (accept != null) {
                    accept.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
