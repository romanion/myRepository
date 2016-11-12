package wrap;

import HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Роман on 07.11.2016.
 */
public class Main {
    public static void main(String args[]) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
