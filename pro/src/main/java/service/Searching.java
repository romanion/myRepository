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

 static public List<ProductsEntity> searchingByName(String name) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List<ProductsEntity> products =
                    session.createCriteria(ProductsEntity.class)
                            .add(Restrictions.eq("name", name))
                            .setMaxResults(10)
                            .list();

            session.getTransaction().commit();


        return products;
    }

    /////////////////////////////////////////////
    static public CustomersEntity accountControl(String email, String password) {
        CustomersEntity customersEntity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
       customersEntity = (CustomersEntity) session.createSQLQuery("select c.* from CUSTOMERS1 c " +
                "WHERE c.EMAIL LIKE('"+email+"')and c.password LIKE('"+password+"')")
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
                "WHERE c.EMAIL LIKE('"+email+"')")
                .addEntity(CustomersEntity.class)
                .uniqueResult();
        session.getTransaction().commit();

        return customersEntity;
    }


   static public List<ProductsEntity> searchingByCategory(String category) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProductsEntity> products =  session.createSQLQuery("select p.* from PRODUCTS1 as p inner JOIN CATEGORIES1 as c " +
                        "ON p.CATEGORY_ID =c.CATRGORY_ID WHERE c.CATEGORY_NAME LIKE('"+category+"')")
                .addEntity(ProductsEntity.class)
                .setMaxResults(10)
                .list();

        session.getTransaction().commit();

        if(products.isEmpty()) System.out.println("This category doesn't exist");

        return  products;
        }
    }



