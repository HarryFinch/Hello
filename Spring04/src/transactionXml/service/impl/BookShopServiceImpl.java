package transactionXml.service.impl;

import transactionXml.BookShopDao;
import transactionXml.service.BookShopService;

/**
 * @author Harold
 * @Date 2020/7/13
 * @Description :
 */

public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao ;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }


    @Override
    public void purchase(String userName, String isbn) {

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Timeout Exception");
        }

        //获取书的单价
        double bookPriceByIsbn = bookShopDao.findBookPriceByIsbn(isbn);

        //更新书的库存
        bookShopDao.updateBookStock(isbn);

        //更新用户余额
        bookShopDao.updateUserAccount(userName, bookPriceByIsbn);

    }
}
