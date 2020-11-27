package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

/**
 * @author Harold
 * @Date 2020/7/13
 * @Description :
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public double findBookPriceByIsbn(String isbn) {
        String sql = "select bookprice from bookshop where bookid = ? ";

        return jdbcTemplate.queryForObject(sql, Double.class, isbn);
    }

    @Override
    public void updateBookStock(String isbn) {

        //检查库存
        String sql1 = "select bookStock from bookshop where bookid = ?";
        int stock = jdbcTemplate.queryForObject(sql1, Integer.class, isbn);
        if (stock > 0) {
            String sql = "update bookshop set bookStock = bookStock - 1 where bookid = ?";
            jdbcTemplate.update(sql, isbn);
        } else {
            throw new BookStockException("库存不足");
        }

    }

    @Override
    public void updateUserAccount(String userName, double price) {

        String sql1 = "select balance from account where userName = ?";
        double balance = jdbcTemplate.queryForObject(sql1, Double.class, userName);

        if (balance < price) {
            throw new  UserAccountException("余额不足");
        } else {
            String sql = "update account set balance = balance - ? where userName = ?";
            jdbcTemplate.update(sql, price, userName);
        }

    }
}


















