package Spring01.annotation.repository;

import Spring01.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description :
 */

@Repository("userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {

    @Autowired(required = false)
    private TestObject testObject;

    @Override
    public void save() {
        System.out.println("UserRepository Save()....");
        System.out.println(testObject);
    }

}
