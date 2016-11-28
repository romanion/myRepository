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
                            boolean adMode, String phone, String email, String password ){


        myCustomersEntity.setAdminMode(adMode);
    //    myCustomersEntity.setCustomerId(BigInteger.valueOf(id));
        myCustomersEntity.setEmail(email);
        myCustomersEntity.setFirstName(firstName);
        myCustomersEntity.setLastName(lastName);
        myCustomersEntity.setPhone(phone);
        myCustomersEntity.setPassword(password);

        this.customerSave();
    }

    public void customerSave() {
        myCustomersDAO.save(myCustomersEntity);
    }
}
