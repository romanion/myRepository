package wrap;

import HibernateUtil.HibernateUtil;
import base.CategoriesEntity;
import intdao.CategoriesInt;
import intdao.CharacteristicsInt;
import org.hibernate.Session;
import base.CharacteristicsEntity;

import java.math.BigInteger;

/**
 * Created by Роман on 05.11.2016.
 */
public class CharacteristicsDAO implements CharacteristicsInt {

    @Override
    public void save(CharacteristicsEntity characteristicsEntity, String name) {
        Session session = getNewSession();
        session.beginTransaction();
        session.saveOrUpdate(name, characteristicsEntity);
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
    public void update(CharacteristicsEntity characteristicsEntity) {
        Session session = getNewSession();
        session.beginTransaction();
        session.update(characteristicsEntity);
        session.getTransaction().commit();

    }
    @Override
    public CharacteristicsEntity getEntityById(long id) {
        CharacteristicsEntity characteristicsEntity;
        Session session = getNewSession();
        session.beginTransaction();
        characteristicsEntity = (CharacteristicsEntity) session.get(CharacteristicsEntity.class, id);
        session.getTransaction().commit();
        return characteristicsEntity;
    }

    private Session getNewSession(){
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

}
