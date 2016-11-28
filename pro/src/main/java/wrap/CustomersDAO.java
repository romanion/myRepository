package wrap;

import HibernateUtil.HibernateUtil;
import intdao.CustomersInt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import base.CustomersEntity;

import java.math.BigInteger;

/**
 * Created by Роман on 05.11.2016.
 */
public class CustomersDAO implements CustomersInt {

    @Override
    public void save(CustomersEntity customersEntity) {
       Session session = getNewSession();
        session.beginTransaction();

        session.save(customersEntity);
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
    public void update(CustomersEntity customersEntity) {
        Session session = getNewSession();
        session.beginTransaction();
        session.update(customersEntity);
        session.getTransaction().commit();
    }
    @Override
    public CustomersEntity getEntityById(long id) {
        CustomersEntity customersEntity;
        Session session = getNewSession();
        session.beginTransaction();
      customersEntity =  (CustomersEntity)session.get(CustomersEntity.class, id);
        session.getTransaction().commit();
        return customersEntity;
    }

    private Session getNewSession(){
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
