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

    public List<ProductsEntity> searchingByName(String name, int maxResults) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List<ProductsEntity> products =
                    session.createCriteria(ProductsEntity.class)
                            .add(Restrictions.eq("name", name))
                            .setMaxResults(maxResults)
                            .list();

            session.getTransaction().commit();


        return products;
    }
    public Object customerByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object customersEntity = session.createSQLQuery("select c.* from CUSTOMERS c " +
                "WHERE c.EMAIL LIKE('"+email+"')")
                .addEntity(CustomersEntity.class)
                .uniqueResult();
        session.getTransaction().commit();

        return customersEntity;
    }
    public List<ProductsEntity> searchingByCategory(String category) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProductsEntity> products =  session.createSQLQuery("select p.* from PRODUCTS as p inner JOIN CATEGORIES as c " +
                        "ON p.CATEGORY_ID =c.CATRGORY_ID WHERE c.CATEGORY_NAME LIKE('"+category+"')")
                .addEntity(ProductsEntity.class)
                .list();

        session.getTransaction().commit();

        if(products.isEmpty()) System.out.println("This category doesn't exist");

        return  products;
        }
    }



