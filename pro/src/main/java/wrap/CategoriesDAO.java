package wrap;
import HibernateUtil.HibernateUtil;
import base.CategoriesEntity;
import intdao.CategoriesInt;
import intdao.CharacteristicsInt;
import org.hibernate.Session;
import base.CharacteristicsEntity;

import java.math.BigInteger;
/**
 * Created by Роман on 27.11.2016.
 */
public class CategoriesDAO implements CategoriesInt {

    @Override
    public void save(CategoriesEntity categoriesEntity, String name) {
        Session session = getNewSession();
        session.beginTransaction();
        session.saveOrUpdate(name, categoriesEntity);
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
    public void update(CategoriesEntity categoriesEntity) {
        Session session = getNewSession();
        session.beginTransaction();
        session.update(categoriesEntity);
        session.getTransaction().commit();

    }
    @Override
    public CategoriesEntity getEntityById(long id) {
        CategoriesEntity categoriesEntity;
        Session session = getNewSession();
        session.beginTransaction();
        categoriesEntity = (CategoriesEntity) session.get(CategoriesEntity.class, id);
        session.getTransaction().commit();
        return categoriesEntity;
    }

    private Session getNewSession(){
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }


}
