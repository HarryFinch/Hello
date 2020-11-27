package transactionXml.service;

import java.util.List;

/**
 * @author Harold
 * @Date 2020/7/15
 * @Description :
 */
public interface Cashier {

    void checkout(String userName, List<String> isbn);

}
