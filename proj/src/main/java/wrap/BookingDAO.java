package wrap;

import shop.BookingsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import HibernateUtil.HibernateUtil;
/**
 * Created by Роман on 05.11.2016.
 */
public class BookingDAO implements BookingInt {
    SessionFactory sessionFactory;
    @Override
    public void save(BookingsEntity bookingEntity) {
    getCurrentSession().save(bookingEntity);
    }
    @Override
    public void delete(long id) {
    getCurrentSession().delete(getEntityById(id));
    }
    @Override
    public void update(BookingsEntity bookingEntity) {
    getCurrentSession().update(bookingEntity);
    }
    @Override
    public BookingsEntity getEntityById(long id) {
    return (BookingsEntity) getCurrentSession().get(BookingsEntity.class, id);
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }
}
