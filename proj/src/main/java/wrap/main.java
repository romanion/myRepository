package wrap;
import org.hibernate.Session;
import shop.*;
import HibernateUtil.HibernateUtil;
/**
 * Created by Роман on 06.11.2016.
 */
public class main {

    public static void main(String args[]){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProductsEntity prod = new ProductsEntity();
        prod.setName("adssd");
        prod.getName();
        session.save(prod);
        session.getTransaction().commit();
    }
}
