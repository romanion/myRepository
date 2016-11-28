package wrap;
import HibernateUtil.HibernateUtil;

import base.CustomersEntity;


import base.MatcherEntity;
import intdao.MatcherInt;
import org.hibernate.Session;


import java.math.BigInteger;

/**
 * Created by Роман on 28.11.2016.
 */
public class MatcherDAO implements MatcherInt {
    @Override
    public void save(MatcherEntity matcherEntity) {
        Session session = getNewSession();
        session.beginTransaction();

        session.save(matcherEntity);
        session.getTransaction().commit();
    }
    @Override
    public void delete(long id) {
        Session session = getNewSession();
        session.beginTransaction();
        session.delete(id);
        session.getTransaction().commit();
    }
    @Override
    public void update(MatcherEntity matcherEntity) {
        Session session = getNewSession();
        session.beginTransaction();
        session.update(matcherEntity);
        session.getTransaction().commit();
    }
    @Override
    public MatcherEntity getEntityById(long id, Session session) {
        MatcherEntity matcherEntity;
        matcherEntity = (MatcherEntity) session.get(MatcherEntity.class, id);
        return matcherEntity ;
    }

    private Session getNewSession(){
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
