package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
 * @author Harold
 * @Date 2020/7/13
 * @Description :
 */

@Service
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao bookShopDao ;


    /*
     * 1、propagation 指定事务的传播行为，即当前事务方法被另外一个事务方法调用时，如何使用事务
     *      默认取值为Propagation.REQUIRED，即调用方法的事务
     *      Propagation.REQUIRED_NEW : 事务是自己的事物，调用的事务方法的事务被挂起
     * 2、isolation 指定事务的隔离级别，最常用的取值为 READ_COMMITTED
     * 3、默认情况下Spring 的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置
     * 4、使用readOnly指定事务是否为只读，表示这个事务只读取数据单不更新数据，
     *      可以帮助数据库引擎优化事务，若是一个只读数据库值的方法，应设置readOnly = true
     * 5、使用timeout指定强制回滚前事务可以占用的时间
     *
     *      @Transactional(propagation = Propagation.REQUIRES_NEW,
     *      isolation = Isolation.READ_COMMITTED,
     *      noRollbackFor = {UserAccountException.class})
     *
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            noRollbackFor = {UserAccountException.class},
            timeout = 10
    )
    @Override
    public void purchase(String userName, String isbn) {

        try {
            Thread.sleep(12000);
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
