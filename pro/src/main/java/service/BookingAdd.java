package service;
import org.hibernate.Session;
import  wrap.*;
import HibernateUtil.*;
import base.*;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Роман on 16.11.2016.
 */
public class BookingAdd {
      private BookingsEntity myBookingEntity = null;
    private BookingDAO myBookingDAO = null;

   public BookingAdd() {
        myBookingDAO = new BookingDAO();
        myBookingEntity = new BookingsEntity();

    }

    public void BookingSet(int sum, Date date, int id, ProductsEntity productsEntity, CustomersEntity customersEntity){


        myBookingEntity.setBookingId(BigInteger.valueOf(id));
        myBookingEntity.setCustomersByCustomerId(customersEntity);
        myBookingEntity.setData((java.sql.Date) date);
        myBookingEntity.setProductsByProductId(productsEntity);
        myBookingEntity.setSum(BigInteger.valueOf(sum));

        this.bookingSave();    }

    public void bookingSave( ) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        myBookingDAO.setSessionFactory(session.getSessionFactory());
        session.beginTransaction();
        myBookingDAO.save(myBookingEntity);
        session.getTransaction().commit();


    }
}
