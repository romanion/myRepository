package wrap;
import org.hibernate.Session;
import base.*;
import HibernateUtil.HibernateUtil;
import org.hibernate.SessionFactory;
import service.*;
import java.math.BigInteger;

/**
 * Created by Роман on 06.11.2016.
 */
public class Main {

    public static void main(String args[]) {
    ProductsAdd productsAdd = new ProductsAdd();

        productsAdd.categoriesSet(5, "trusy", 2);
        productsAdd.characteristicsSet(6, "blue", 20, 0.2);
        productsAdd.productsSet(6, "CalvinKlein", 2200, true);

    }
}
