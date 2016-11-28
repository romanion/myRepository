package work;
import base.*;
import wrap.*;
import service.*;
import HibernateUtil.*;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Роман on 21.11.2016.
 */
public class ConsoleInterface {

    Scanner scanner;

    public ConsoleInterface(){
        scanner = new Scanner(System.in);
    }

    public void authentication() throws IOException {
        while (true) {
            User user = new User();
            String answer;
            Object obj = user.userAuthentication(scanner);
            if (obj != null) {
                if (((User) obj).getAdminMode()) {

                    System.out.println("Do you want get to Administaration mode? y/n \n");
                    answer = scanner.next("(.*?)");
                    if (answer.equalsIgnoreCase("y")) {
                        enterCommand((Admin) obj);
                    }
                    {
                        if (answer.equalsIgnoreCase("n")) enterCommand((User) obj);
                    }
                } else {
                    enterCommand((User) obj);
                }
            }
        }
    }

    public void enterCommand(User user) throws IOException {
        while(true){
            System.out.println("Enter command \n" +
                    "or use help (help_me)");
            String buffer = new String();
            //try{
                buffer =  scanner.next("(.*?)_(.*?)");
            /*}catch(InputMismatchException ex){
                throw  new RuntimeException("Error1") ;
            } catch(NoSuchElementException e){
                throw  new RuntimeException("Error2") ;
            }*/
            Pattern pattern = Pattern.compile("(.*?)_(.*?)");
            Matcher matcher = pattern.matcher(buffer);
            if(matcher.matches()){
                firstParser(matcher.group(1), matcher.group(2), user);
            }
            else {
                System.out.println("Your command is incorrect");
            }
        }

    }

    public void showHelpList(/*String path*/) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader("D:\\help.txt") );
        String s;
        while((s = rd.readLine())!= null) {
            System.out.println(s);
        }
        rd.close();
    }
    public void enterCommand(Admin user){
       System.out.println("You are ADMIN");
        }



    public void firstParser(String firstCom, String secondCom, User user) throws IOException {
        switch(firstCom.toLowerCase()){
            case "find":
                findParser(secondCom, user);
                break;
            case "add":
               addParser(secondCom, user);
                break;
            case "buy":
                buyParser(secondCom, user);
                break;
            case "delete":
                deleteParser(secondCom, user);
                break;
            case "help":
                showHelpList();
                break;
        }
    }

    public void deleteParser(String secondCom, User user){
        switch(secondCom.toLowerCase()){
            case "product":
                deleteProductParser(user);
                break;
        }
    }
    public void buyParser(String secondCom, User user){
        switch(secondCom.toLowerCase()){
            case "products":
                buyProductParser(user);
                break;
        }
    }

    public void findParser(String secondCom, User user){
        switch(secondCom.toLowerCase()){
            case "products":
               findProductParser(user);
                break;
        }
    }


    public void addParser(String secondCom, User user){
        switch(secondCom.toLowerCase()){
            case "product":
                addProductParser(user);
                break;
        }
    }
    public void addProductParser(User user){
       System.out.println("Enter product identification number (ID)");
       int id = scanner.nextInt();
        user.addProdToBasket(id);

    }

    public void deleteProductParser(User user){
        System.out.println("Enter product identification number (ID)");
        int id = scanner.nextInt();
        user.deleteFromBasket(id);

    }

    public void findProductParser(User user){
        System.out.println("Enter criteria of searching:\n");
        String criteria = scanner.next("(.*?)");
        System.out.println("Enter value:\n");
        String value = scanner.next("(.*?)");
        user.find(criteria, value);
    }

    public void buyProductParser(User user){
        user.buy();
    }
}
