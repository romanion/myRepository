package wrap;

import HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import base.ProductsEntity;

import java.math.BigInteger;

/**
 * Created by Роман on 05.11.2016.
 */
public class ProductsDAO implements ProductsInt {
    SessionFactory sessionFactory;
    @Override
    public void save(ProductsEntity productsEntity, String name) {
        getCurrentSession().saveOrUpdate(name, productsEntity);
    }
    @Override
    public void delete(BigInteger id) {
        getCurrentSession().delete(getEntityById(id));
    }

    @Override
    public void update(ProductsEntity productsEntity) {
        getCurrentSession().update(productsEntity);
    }

    @Override
    public ProductsEntity getEntityById(BigInteger id) {
        return (ProductsEntity)  getCurrentSession().get(ProductsEntity.class, id);

    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }
}
