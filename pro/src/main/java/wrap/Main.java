package wrap;
import org.hibernate.Session;
import base.*;
import HibernateUtil.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import service.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import work.*;
/**
 * Created by Роман on 06.11.2016.
 */
public class Main {

    public static void main(String args[]) throws IOException {

      /*  User user = new User();

        user.createUser();*/

       ConsoleInterface consoleInterface = new ConsoleInterface();
       consoleInterface.authentication();

     /*   User user = new User();
        user.createUser();*/
//     Searching sea = new Searching();
//        System.out.println(sea.searchingByCategory("trus").get(0).getName());
        /* *//* Searching sea = new Searching();
        System.out.println(sea.searchingByCategory("trusy", 1).get(0).getName());
        *//**//* String str = "PS";*//*
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProductsEntity> list = session.createSQLQuery("select p.* from PRODUCTS as p " +
                "where p.name LIKE(str)")
                .addEntity(ProductsEntity.class)
                .list();

        session.getTransaction().commit();
        System.out.println(list.get(0).getName());*/
    }
}
