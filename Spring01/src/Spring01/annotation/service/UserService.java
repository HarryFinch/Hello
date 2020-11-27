package Spring01.annotation.service;

import Spring01.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Harold
 * @Date 2020/5/29
 * @Description :
 *  1、配置的时候，可以让@Repository("值")与对象名一致
 */

@Service
public class UserService {

    @Autowired
    @Qualifier("userRepositoryImpl")
    private UserRepository userRepository;

//    @Autowired
//    @Qualifier("userRepositoryImpl")
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public void add() {
        System.out.println("UserService add()....");
        userRepository.save();
    }

}
