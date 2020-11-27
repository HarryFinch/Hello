package Spring01.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @author Harold
 * @Date 2020/5/31
 * @Description :
 */
@Repository
public class UserJdbcRepository implements UserRepository {

    @Override
    public void save() {
        System.out.println("UserJdbcRepository save()...");
    }

}
