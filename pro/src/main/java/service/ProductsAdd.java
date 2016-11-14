package service;
import org.hibernate.Session;
import  wrap.*;
import HibernateUtil.*;
import base.*;

import java.math.BigInteger;

/**
 * Created by Роман on 13.11.2016.
 */
public class ProductsAdd {
    private CategoriesEntity myCategoriesEntity;
    private CharacteristicsEntity myCharacteristicsEntity;

    public void categoriesSet(int id, String name, int pid ){
        CategoriesEntity categoriesEntity = new CategoriesEntity();

            categoriesEntity.setCategoryId(BigInteger.valueOf(id));
            categoriesEntity.setCatrgoryName(name);
            categoriesEntity.setParentId(BigInteger.valueOf(pid));

                this.categoriesSave(categoriesEntity, name);
    }

    public void categoriesSave(CategoriesEntity categoriesEntity, String name ) {
        CategoriesDAO dao = new CategoriesDAO();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            dao.setSessionFactory(session.getSessionFactory());
                session.beginTransaction();
                    dao.save(categoriesEntity, name);
                        session.getTransaction().commit();
        this.myCategoriesEntity = categoriesEntity;
    }

    public void characteristicsSet(int id, String color, double size, double weight){
        CharacteristicsEntity characteristicsEntity = new CharacteristicsEntity();

            characteristicsEntity.setCharacteristicId(BigInteger.valueOf(id));
            characteristicsEntity.setColor(color);
            characteristicsEntity.setSize(Double.valueOf(size));
            characteristicsEntity.setWeight(Double.valueOf(weight));


        this.characteristicsSave(characteristicsEntity, color);
    }

    public void characteristicsSave(CharacteristicsEntity characteristicsEntity, String name) {
        CharacteristicsDAO dao = new CharacteristicsDAO();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        dao.setSessionFactory(session.getSessionFactory());
        session.beginTransaction();
        dao.save(characteristicsEntity, name);
        session.getTransaction().commit();
        this.myCharacteristicsEntity = characteristicsEntity;
    }

    public void productsSet(int id, String name, int prize, boolean ava){
        ProductsEntity productsEntity = new ProductsEntity();

            productsEntity.setProductAvailability(ava);
            productsEntity.setPrize(BigInteger.valueOf(prize));
            productsEntity.setProductId(BigInteger.valueOf(id));
            productsEntity.setName(name);

            productsEntity.setCategoriesByCategoryId(this.myCategoriesEntity);
            productsEntity.setCharacteristicsByCharacteristicId(this.myCharacteristicsEntity);



        this.productsSave(productsEntity, name);
    }

    public void productsSave(ProductsEntity productsEntity, String name) {
       ProductsDAO dao = new ProductsDAO();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        dao.setSessionFactory(session.getSessionFactory());
        session.beginTransaction();
        dao.save(productsEntity, name);
        session.getTransaction().commit();
    }
}
