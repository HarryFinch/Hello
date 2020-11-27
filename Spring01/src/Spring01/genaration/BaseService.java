package Spring01.genaration;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Harold
 * @Date 2020/5/31
 * @Description :
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add(){
        System.out.println("BaseService add() ... ");
        System.out.println("BaseService " + repository);
    }

}
