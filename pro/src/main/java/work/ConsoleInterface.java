package work;
import base.*;
import wrap.*;
import service.*;
import HibernateUtil.*;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.webpane.platform.ConfigManager.log;

/**
 * Created by Роман on 21.11.2016.
 */
public class ConsoleInterface {

    Scanner scanner;

    public ConsoleInterface(){
        scanner = new Scanner(System.in);
    }

   /* static {
        try {
            System.setErr(new PrintStream(new File("log.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("file not exists!");
        }
    }*/

    public void authentication() throws IOException {
        while (true) {
            User user = new User();
            String answer;
            Object obj = user.userAuthentication(scanner);
            if (obj != null) {
                if (((User) obj).getAdminMode()) {
                    System.out.println("Do you want get to Administaration mode? y/n \n");
                    Admin admin = new Admin();
                    answer = scanner.next("(.*?)");
                    if (answer.equalsIgnoreCase("y")) {
                        enterAdminCommand(admin);
                    }
                    {
                        if (answer.equalsIgnoreCase("n")) enterUserCommand(admin);
                    }
                } else {
                    enterUserCommand(user);
                }
            }
        }
    }

    public void enterUserCommand(User user)  {
        while(true){
            if(user.email==null) System.out.println("0099090990999090000000000000000000000000000");

            System.out.println("Enter command \n" +
                    "or use help (help_me)");
            String buffer = new String();

                buffer =  scanner.next("(.*?)_(.*?)");

            Pattern pattern = Pattern.compile("(.*?)_(.*?)");
            Matcher matcher = pattern.matcher(buffer);
            if(matcher.matches()){
                try {
                    firstParser(matcher.group(1), matcher.group(2), user);
                } catch (IOException ex) {
                    log.log(Level.SEVERE, "Exception: ", ex);
                }
            }
            else {
                System.out.println("Your command is incorrect");
            }
        }

    }

    public void showHelpList(/*String path*/)  {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader("C:\\Users\\Роман\\IdeaProjects\\pro\\src\\main\\java\\work\\help.txt") );
            String s;
            while((s = rd.readLine())!= null) {
                System.out.println(s);
            }
            rd.close();
        } catch (FileNotFoundException ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }

    }
    public void enterAdminCommand(Admin admin){
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
            case "show":
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

    public void showParser(String secondCom, User user){
        switch(secondCom.toLowerCase()){
            case "bills":
                //showBillsParser(user);
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
       int id = scanner.nextInt();//////////////////exeption
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
        user.equals(null);

        user.buy(user);
    }
}
