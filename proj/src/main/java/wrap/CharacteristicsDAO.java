package wrap;

import HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import shop.CharacteristicsEntity;

/**
 * Created by Роман on 05.11.2016.
 */
public class CharacteristicsDAO implements CharacteristicsInt {
    SessionFactory sessionFactory;
    @Override
    public void save(CharacteristicsEntity characteristicsEntity) {
        getCurrentSession().save(characteristicsEntity);
    }
    @Override
    public void delete(long id) {
        getCurrentSession().delete(getEntityById(id));
    }
    @Override
    public void update(CharacteristicsEntity characteristicsEntity) {
        getCurrentSession().update(characteristicsEntity);
    }
    @Override
    public CharacteristicsEntity getEntityById(long id) {
        return (CharacteristicsEntity) getCurrentSession().get(CharacteristicsEntity.class, id);
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }
}
