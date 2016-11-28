package work;
import base.*;
import wrap.*;
import service.*;
import HibernateUtil.*;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

/**
 * Created by Роман on 15.11.2016.
 */
public class User {
    private List<ProductsEntity> basket = null;
    private CustomersEntity myUser = null;
    private String email;
    private String password;
    private boolean adminMode = false;



    public void addProdToBasket(long id) throws NullPointerException{
        if(basket==null) basket = new ArrayList<ProductsEntity>();
        ProductsDAO productsDAO = new ProductsDAO();
        ProductsEntity productsEntity = productsDAO.getEntityById(id);
            basket.add(productsEntity);
        System.out.println(productsEntity.getName() + " add to your basket");
    }

    public void deleteFromBasket(long id)  {

        if(this.basket.isEmpty()) System.out.println("Your basket is empty");
         else{
            ProductsDAO productsDAO = new ProductsDAO();
            ProductsEntity productsEntity = productsDAO.getEntityById(id);
            for(ProductsEntity entity: basket) {
                 if (entity.equals(productsEntity)) {
                     this.basket.remove(productsEntity);
                     System.out.println(productsEntity.getName() + " deleted from your basket");
                     //back to main class
                 }

             }
         System.out.println("There isn't this product in your basket");
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
        System.out.println("Enter your password");
        String password = newscan.nextLine();
        System.out.println("Phone:");
        String phone = newscan.nextLine();
        UserAdd userAdd = new UserAdd();
        userAdd.consumerSet(phone.length(), lastName, firstName, false, phone, email, password);
    }

  public void buy(){
        int sum;
        sum = calculateSum();
        if(sum==0){
            System.out.println("Your basket is empty");
        }
        else{
            BookingAdd bookingAdd = new BookingAdd();
            bookingAdd.BookingSet(sum, new Date(), this.basket, myUser);

        }


    }

    public int calculateSum(){
        int sum = 0;
        for(int i=0;i<basket.size();i++){
            sum = sum + basket.get(i).getPrize().intValue();
        }
        return sum;
    }

    public Object userAuthentication(Scanner scanner) {
        String buffer1 = new String(), buffer2 = new String();
        try{
            System.out.println("Enter your e-mail:\n ");
            buffer1 =  scanner.next("(.*?)");
            System.out.println("Enter your password:\n ");
            buffer2 =  scanner.next("(.*?)");
        }catch(InputMismatchException ex){
        } catch(NoSuchElementException e){
        }
        Pattern pattern1 = Pattern.compile("(.*?)");
        Pattern pattern2 = Pattern.compile("(.*?)");
        Matcher matcher1 = pattern1.matcher(buffer1);
        Matcher matcher2 = pattern2.matcher(buffer2);
        matcher1.matches();
        matcher2.matches();
        if(matcher1.matches()&&matcher2.matches()){
            this.email = matcher1.group(1);
            this.password = matcher2.group(1);

            this.myUser = Searching.accountControl(this.email, this.password);
            if(this.myUser!=null){
                return checkAdmin();
            }
                else{
                System.out.println("Your e-mail and password is incorrect \n" +
                        "                          Please try enter again");
                return null;
            }
        }
        else{
            System.out.println("Password or username does not meet the criteria");
            return null;
        }
    }

    public Object checkAdmin(){
        if(this.myUser.getAdminMode()==true){
            User admin = new Admin();
            admin.adminMode = true;
            return admin;
        }
        else{
            return this;
        }
    }
    public boolean getAdminMode(){
        return this.adminMode;
    }

    public void find(String criteria, String value){

        switch(criteria){
            case "name":
                print(Searching.searchingByName(value));
                break;
            case "category":
                print(Searching.searchingByCategory(value));
                break;
            case "property":
                break;
        }

    }

    public void print(List<ProductsEntity> productsEntities) {
        if (productsEntities.size() > 0) {
            System.out.println("id    name     prize");
            for (int i = 0; i < productsEntities.size(); i++) {
                System.out.println(productsEntities.get(i).getProductId() + "||" +
                        productsEntities.get(i).getName() + "||" +
                        productsEntities.get(i).getPrize() + "rub.||"/* +
                        productsEntities.get(i).getCharacteristicsByCharacteristicId().getColor() + "||" +
                        productsEntities.get(i).getCharacteristicsByCharacteristicId().getSize() + "||" +
                        productsEntities.get(i).getCharacteristicsByCharacteristicId().getWeight() + "||"*/);
            }
        }
        else{
            System.out.println("Nothing found");
        }
    }

}
