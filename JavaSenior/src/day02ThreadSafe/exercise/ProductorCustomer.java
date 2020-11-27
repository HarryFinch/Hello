package day02ThreadSafe.exercise;

/*
 * @Author: Harold
 * @Date: 2020/3/19 14:55
 * @Description:生产者消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处 取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图 生产更多的产品，店员会叫生产者停一下，
 * 如果店中有空位放产品了再通 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 *
 */
public class ProductorCustomer {
}


class Productor {

}

class Clerk {

}

class Store {
    public int number = 0 ;
}