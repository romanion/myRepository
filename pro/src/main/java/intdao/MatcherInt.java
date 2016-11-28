package intdao;

import base.MatcherEntity;
import org.hibernate.Session;

import java.math.BigInteger;

/**
 * Created by Роман on 27.11.2016.
 */
public interface MatcherInt {
    public void save(MatcherEntity matcherEntity);
    public void delete(long id);
    public void update(MatcherEntity matcherEntity);
    public  MatcherEntity getEntityById(long id, Session session);
}
