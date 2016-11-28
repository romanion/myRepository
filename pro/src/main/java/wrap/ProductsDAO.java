package wrap;

import HibernateUtil.HibernateUtil;
import intdao.ProductsInt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import base.ProductsEntity;

import java.math.BigInteger;

/**
 * Created by Роман on 05.11.2016.
 */
public class ProductsDAO implements ProductsInt {

    @Override
    public void save(ProductsEntity productsEntity, String name) {
       Session session = getNewSession();
        session.beginTransaction();
        session.saveOrUpdate(name, productsEntity);
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
    public void update(ProductsEntity productsEntity) {
        Session session = getNewSession();
        session.beginTransaction();
        session.update(productsEntity);
        session.getTransaction().commit();
    }

    @Override
    public ProductsEntity getEntityById(long id) {
        ProductsEntity productsEntity;
        Session session = getNewSession();
        session.beginTransaction();
      productsEntity = (ProductsEntity)  session.get(ProductsEntity.class, id);
        session.getTransaction().commit();
        return productsEntity;
    }

    private Session getNewSession(){
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

  /*  public void createSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }*/
}
