package wrap;

import HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import shop.CategoriesEntity;

/**
 * Created by Роман on 05.11.2016.
 */
public class CategoriesDAO implements CatigoriesInt {
    SessionFactory sessionFactory;
    @Override
    public void save(CategoriesEntity categoriesEntity) {
        getCurrentSession().save(categoriesEntity);
    }
    @Override
    public void delete(long id) {
        getCurrentSession().delete(getEntityById(id));
    }
    @Override
    public void update(CategoriesEntity categoriesEntity) {
        getCurrentSession().update(categoriesEntity);
    }
    @Override
    public CategoriesEntity getEntityById(long id) {
        return (CategoriesEntity) getCurrentSession().get(CategoriesEntity.class, id);
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }
}
