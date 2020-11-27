package day10Proxy;

/*
 * @author Harold
 * @Date 2020/4/23
 * @Description : 静态代理举例
 *  特点 ； 代理类和被代理类在编译期间就确定了
 */

interface ClothFactory {
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;//使用被代理类对象实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂的准备工作");
        factory.produceCloth();
        System.out.println("被代理工厂的收尾工作");
    }
}

class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike produced sport cloth");
    }
}


public class StaticProxy {


    public static void main(String[] args) {
        //被代理类对象
        NikeClothFactory nike = new NikeClothFactory();
        //代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }

}
