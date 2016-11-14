package wrap;

import HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import base.CategoriesEntity;

import java.math.BigInteger;

/**
 * Created by Роман on 05.11.2016.
 */
public class CategoriesDAO implements CategoriesInt {
    SessionFactory sessionFactory;
    @Override
    public void save(CategoriesEntity categoriesEntity, String name) {
        getCurrentSession().saveOrUpdate(name, categoriesEntity);
    }
    @Override
    public void delete(BigInteger id) {
        getCurrentSession().delete(getEntityById(id));
    }
    @Override
    public void update(CategoriesEntity categoriesEntity) {
        getCurrentSession().update(categoriesEntity);
    }
    @Override
    public CategoriesEntity getEntityById(BigInteger id) {
        return (CategoriesEntity) getCurrentSession().get(CategoriesEntity.class, id);
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }
}
