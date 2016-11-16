package work;
import base.*;
import wrap.*;
import service.*;
import HibernateUtil.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Роман on 15.11.2016.
 */
public class User {
    private List<ProductsEntity> basket = null;

    public void addProdToBascket(ProductsEntity prod) throws NullPointerException{
        if(basket==null) basket = new ArrayList<ProductsEntity>();

            basket.add(prod);
        System.out.println(prod.getName() + " add to your basket");
    }

    public void deleteFromBasket(ProductsEntity prod)  {
     try{
         prod.equals(null);
         if(this.basket.isEmpty()) System.out.println("Your basket is empty");
         else{
             for(ProductsEntity entity: basket) {
                 if (entity.equals(prod)) {
                     basket.remove(prod);
                     System.out.println(prod.getName() + " deleted");
                     //back to main class
                 }

             }
         System.out.println("There isn't this product in your basket");
         }
     }catch (NullPointerException ex){
         ex.getStackTrace();
     }

    }
    public void createUser()  {
    Scanner newscan = new Scanner(System.in);

        System.out.println("Enter your e-mail");
        String email = newscan.nextLine();
        System.out.println("Enter you firstName");
        String firstName = newscan.nextLine();
        System.out.println("Enter your lastName");
        String lastName = newscan.nextLine();
        System.out.println("Phone:");
        int phone = 228322;

        UserAdd userAdd = new UserAdd();
        userAdd.consumerSet(phone - 99999, lastName, firstName, false, phone, email);
    }


}
