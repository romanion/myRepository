package wrap;

import base.BookingsEntity;
import intdao.BookingInt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import HibernateUtil.HibernateUtil;

import java.math.BigInteger;

/**
 * Created by Роман on 05.11.2016.
 */
public class BookingDAO implements BookingInt {

    @Override
    public void save(BookingsEntity bookingEntity) {
        Session session = getNewSession();;
        session.beginTransaction();
        session.save(bookingEntity);

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
    public void update(BookingsEntity bookingEntity) {
        Session session = getNewSession();
        session.beginTransaction();
        session.update(bookingEntity);
        session.getTransaction().commit();

    }
    @Override
    public BookingsEntity getEntityById(long id) {
        BookingsEntity bookingsEntity;
        Session session = getNewSession();
        session.beginTransaction();
        bookingsEntity = (BookingsEntity) session.get(BookingsEntity.class, id);
        session.getTransaction().commit();
        return bookingsEntity;
    }

    private Session getNewSession(){
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
