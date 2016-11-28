package service;
import org.hibernate.Session;
import  wrap.*;
import HibernateUtil.*;
import base.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 16.11.2016.
 */
public class BookingAdd {
      private BookingsEntity myBookingEntity = null;
    private BookingDAO myBookingDAO = null;
    private MatcherEntity myMatcherEntity = null;
    private MatcherDAO myMatcherDAO = null;

   public BookingAdd() {
        myBookingDAO = new BookingDAO();
        myBookingEntity = new BookingsEntity();
       myMatcherDAO = new MatcherDAO();
       myMatcherDAO  = new MatcherDAO();


   }

    public void BookingSet(int sum, Date date,  List<ProductsEntity> productsEntity, CustomersEntity customersEntity){
        List<BookingsEntity> bookingsEntities = new ArrayList<BookingsEntity>();
        for(int i=0;i<productsEntity.size();i++) {
            myBookingEntity.setCustomersByCustomerId(customersEntity);
          //  myBookingEntity.setData((java.sql.Date) date);
            myBookingEntity.setSum(BigInteger.valueOf(sum));
            bookingsEntities.add(this.myBookingEntity);
            this.bookingSave();
        }


    }

    public void bookingSave( ) {

        myBookingDAO.save(myBookingEntity);
    }

    public void matcherSet(List<ProductsEntity> productsEntity, List<BookingsEntity> bookingsEntities){
        for(int i = 0; i<bookingsEntities.size();i++){
            myMatcherEntity.setProductsByProductId(productsEntity.get(i));
            myMatcherEntity.setBookingsByBookingId(bookingsEntities.get(i));
            this.matcherSave();
        }
    }
    public void matcherSave( ) {

        myMatcherDAO.save(this.myMatcherEntity);
    }
}
