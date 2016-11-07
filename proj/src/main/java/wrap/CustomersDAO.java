package wrap;

import HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import shop.CustomersEntity;

/**
 * Created by Роман on 05.11.2016.
 */
public class CustomersDAO implements CustomersInt {
    SessionFactory sessionFactory;
    @Override
    public void save(CustomersEntity customersEntity) {
        getCurrentSession().save(customersEntity);
    }
    @Override
    public void delete(long id) {
        getCurrentSession().delete(getEntityById(id));
    }
    @Override
    public void update(CustomersEntity customersEntity) {
        getCurrentSession().update(customersEntity);
    }
    @Override
    public CustomersEntity getEntityById(long id) {
        return (CustomersEntity) getCurrentSession().get(CustomersEntity.class, id);
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }
}
