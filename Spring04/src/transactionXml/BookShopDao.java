package transactionXml;

/**
 * @author Harold
 * @Date 2020/7/13
 * @Description :
 */
public interface BookShopDao {

    //根据书号获取书的单价
    double findBookPriceByIsbn(String isbn);

    //根据书号，更新库存
    void updateBookStock(String isbn);

    //更新用户账户余额
    void  updateUserAccount(String userName, double price);

}
