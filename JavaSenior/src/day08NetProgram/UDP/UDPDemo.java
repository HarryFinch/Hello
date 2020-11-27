package day08NetProgram.UDP;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * @author Harold
 * @Date 2020/4/10
 * @Description : UDP 的网络编程
 */
public class UDPDemo {

    @Test
    public void send() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String str = "UDP方式发送的数据";
            byte[] data = str.getBytes();
            InetAddress inet = InetAddress.getLoopbackAddress();
            DatagramPacket packet = new DatagramPacket(data,0, data.length,inet , 9090);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null ) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void reciever() {
        try {
            DatagramSocket socket = new DatagramSocket(9090);

            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData() , 0 , packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

}


