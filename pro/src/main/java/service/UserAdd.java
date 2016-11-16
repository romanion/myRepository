package service;
import org.hibernate.Session;
import  wrap.*;
import HibernateUtil.*;
import base.*;

import java.math.BigInteger;

/**
 * Created by Роман on 16.11.2016.
 */
public class UserAdd {

    private CustomersEntity myCustomersEntity = null;
    private CustomersDAO myCustomersDAO = null;

    public UserAdd() {
        myCustomersDAO = new CustomersDAO();
        myCustomersEntity = new CustomersEntity();
    }

    public void consumerSet(int id, String lastName, String firstName,
                            boolean adMode, int phone, String email ){


        myCustomersEntity.setAdminMode(adMode);
        myCustomersEntity.setCustomerId(BigInteger.valueOf(id));
        myCustomersEntity.setEmail(email);
        myCustomersEntity.setFirstName(firstName);
        myCustomersEntity.setLastName(lastName);
        myCustomersEntity.setPhone(BigInteger.valueOf(phone));

        this.customerSave();
    }

    public void customerSave() {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        myCustomersDAO.setSessionFactory(session.getSessionFactory());
        session.beginTransaction();
        myCustomersDAO.save(myCustomersEntity);
        session.getTransaction().commit();


    }
}
