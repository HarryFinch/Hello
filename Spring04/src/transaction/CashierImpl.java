package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Harold
 * @Date 2020/7/15
 * @Description :
 */

@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

   @Transactional
    @Override
    public void checkout(String userName, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(userName, isbn);
        }
    }
}
