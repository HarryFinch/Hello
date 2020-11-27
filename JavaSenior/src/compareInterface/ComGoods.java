package compareInterface;

import java.util.Comparator;

/*
 * @Author: Harold
 * @Date: 2020/3/22 16:20
 * @Description: 商品排序
 */
public class ComGoods implements Comparable {
    private String name ;
    private double price ;

    public ComGoods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ComGoods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明按照什么方式排序，如按价格
    @Override
    public int compareTo(Object o) {
        if(o instanceof ComGoods){
            ComGoods goods = (ComGoods)o;
            if(this.price > goods.price) {
                return 1;
            }else if(this.price < goods.price) {
                return -1 ;
            }else {
                return 0;
            }
//            return Double.compare(this.price , goods.price);
        }
        throw  new RuntimeException("Wrong");
    }
}
