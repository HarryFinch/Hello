package transactionXml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transactionXml.service.BookShopService;
import transactionXml.service.Cashier;

import java.util.Arrays;

/**
 * @author Harold
 * @Date 2020/7/13
 * @Description :
 */
public class BookTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    @Test
    public void testTransactionPropagation() {
        cashier.checkout("Harold", Arrays.asList("1001","1002"));
    }


    @Test
    public void testBookShopService() {
        bookShopService.purchase("Harold", "1002");
    }


}
