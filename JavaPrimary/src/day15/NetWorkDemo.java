package day15;

import sun.nio.ch.Net;

/*
    接口的应用：代理模式
 */
public class NetWorkDemo {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
//        new ProxyServer(new Server());
        proxyServer.browse();
    }
}

interface NetWork{
    public void browse();
}

//被代理类
class Server implements NetWork{

    @Override
    public void browse() {
        System.out.println("NetWork is working");
    }
}

//代理类
class ProxyServer implements NetWork{

    private NetWork netWork ;

    public ProxyServer(NetWork netWork){
        this.netWork = netWork;
    }

    public void check(){
        System.out.println("Checked the network before connecting network");
    }
    @Override
    public void browse() {

    }
}