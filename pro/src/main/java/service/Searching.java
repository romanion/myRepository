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
    public List<ProductsEntity> searchingByCategory(String category, int maxResults) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProductsEntity> products = session.createCriteria(ProductsEntity.class)
              //  .add(Restrictions.eq(""))
                .createAlias("CategoriesEntity", "cat")
                .add(Restrictions.ge("cat.category_name", category))
                .setMaxResults(maxResults)
                .setMaxResults(1)
                .list();
        session.getTransaction().commit();


        return products;
        }
    }



