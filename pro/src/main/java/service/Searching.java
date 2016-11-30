package service;
import HibernateUtil.HibernateUtil;
import base.*;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Join;
import  wrap.*;

import java.util.List;

/**
 * Created by Роман on 14.11.2016.
 */
public class Searching {



 static public void searchingByName(String name) {
     List<ProductsEntity> products = null;
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
     session.beginTransaction();
     products =
             session.createCriteria(ProductsEntity.class)
                     .add(Restrictions.eq("name", name))
                     .setMaxResults(10)
                     .list();

     if (products.isEmpty()) System.out.println("This category doesn't exist");
     else {
         print(products);
         session.getTransaction().commit();


     }
 }
    /////////////////////////////////////////////
    static public CustomersEntity accountControl(String email, String password) {
        CustomersEntity customersEntity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
       customersEntity = (CustomersEntity) session.createSQLQuery("select c.* from CUSTOMERS1 c " +
                "WHERE c.EMAIL LIKE ('"+email+"') and c.password = '"+password+"'")
                .addEntity(CustomersEntity.class)
                .uniqueResult();
        session.getTransaction().commit();
        return customersEntity;
    }
/////////////////////////////////////////////////////

    static public Object customerByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object customersEntity = session.createSQLQuery("select c.* from CUSTOMERS1 c " +
                "WHERE (c.EMAIL = "+email)

                .uniqueResult();
        session.getTransaction().commit();

        return customersEntity;
    }


    static public void searchingBildByUser(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<MatcherEntity> matcherEntities =
                session.createSQLQuery("select m.* from  MATCHER1 as m  " +
                        " INNER JOIN BOOKINGS1 as b ON m.booking_id = b.booking_id "+
                        " INNER JOIN PRODUCTS as p ON m.product_id = p.product_id "+
                        "  WHERE b.customer_id = "+id+"")
                .addEntity(MatcherEntity.class)
                .setMaxResults(10)
                .list();
        if(matcherEntities==null) System.out.println("This category doesn't exist");
        else {
      System.out.println("ok:)");
             print1(matcherEntities);
        }
        session.getTransaction().commit();
    }

    public static void print1(List<MatcherEntity> matcherEntities) {
        if (matcherEntities.size() > 0) {
            System.out.println("id    name     prize     color     size     weight");
            BookingsEntity tmp = new BookingsEntity();
            for (int i = 0; i < matcherEntities.size(); i++) {
               if(tmp.equals(matcherEntities.get(i).getBookingsByBookingId())!=true){
                   tmp = matcherEntities.get(i).getBookingsByBookingId();
                System.out.println("Bild ID: "+tmp.getBookingId());
                           System.out.println("Sum: "+tmp.getSum()+"rub");
                   System.out.println("Date: "+tmp.getData());
                   System.out.println(matcherEntities.get(i).getProductsByProductId().getName() + "||" +
                           matcherEntities.get(i).getProductsByProductId().getProductId()+"||" +
                           matcherEntities.get(i).getProductsByProductId().getPrize());
               }
                   else{
                   System.out.println(matcherEntities.get(i).getProductsByProductId().getName() + "||" +
                           matcherEntities.get(i).getProductsByProductId().getProductId()+"||" +
                           matcherEntities.get(i).getProductsByProductId().getPrize());
               }
               }

        }
        else{
            System.out.println("Nothing found");
        }
    }


    static public void searchingByCategory(String category) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProductsEntity> products =  session.createSQLQuery("select p.* from PRODUCTS1 as p inner JOIN CATEGORIES1 as c " +
                        "ON p.CATEGORY_ID =c.CATRGORY_ID WHERE c.CATEGORY_NAME LIKE '"+category+"'")
                .addEntity(ProductsEntity.class)
                .setMaxResults(10)
                .list();
       if(products.isEmpty()) System.out.println("This category doesn't exist");
       else {
           print(products);
       }
        session.getTransaction().commit();
        }

    public static void print(List<ProductsEntity> productsEntities) {
        if (productsEntities.size() > 0) {
            System.out.println("id    name     prize     color     size     weight");

            for (int i = 0; i < productsEntities.size(); i++) {
                System.out.println(productsEntities.get(i).getProductId() + "||" +
                        productsEntities.get(i).getName() + "||" +
                        productsEntities.get(i).getPrize() + "rub.||" +
                        productsEntities.get(i).getCharacteristicsByCharacteristicId().getColor() + "||" +
                        productsEntities.get(i).getCharacteristicsByCharacteristicId().getSize() + "||" +
                        productsEntities.get(i).getCharacteristicsByCharacteristicId().getWeight() + "kg||");
            }

        }
        else{
            System.out.println("Nothing found");
        }
    }
    }



