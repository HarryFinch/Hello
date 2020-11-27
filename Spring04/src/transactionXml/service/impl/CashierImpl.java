package transactionXml.service.impl;

import transactionXml.service.BookShopService;
import transactionXml.service.Cashier;

import java.util.List;

/**
 * @author Harold
 * @Date 2020/7/15
 * @Description :
 */

public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String userName, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(userName, isbn);
        }
    }
}
