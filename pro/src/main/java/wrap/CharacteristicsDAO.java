package wrap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import base.CharacteristicsEntity;

import java.math.BigInteger;

/**
 * Created by Роман on 05.11.2016.
 */
public class CharacteristicsDAO implements CharacteristicsInt {
    SessionFactory sessionFactory;
    @Override
    public void save(CharacteristicsEntity characteristicsEntity, String name) {
        getCurrentSession().saveOrUpdate(name, characteristicsEntity);
    }
    @Override
    public void delete(BigInteger id) {
        getCurrentSession().delete(getEntityById(id));
    }
    @Override
    public void update(CharacteristicsEntity characteristicsEntity) {
        getCurrentSession().update(characteristicsEntity);
    }
    @Override
    public CharacteristicsEntity getEntityById(BigInteger id) {
        return (CharacteristicsEntity) getCurrentSession().get(CharacteristicsEntity.class, id);
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }
}
