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
    private CategoriesEntity myCategoriesEntity = null;
    private CharacteristicsEntity myCharacteristicsEntity = null;

    private ProductsDAO productsDAO = null;
   private CharacteristicsDAO characteristicsDAO = null;
    CategoriesDAO categoriesDAO = null;

    public ProductsAdd(){
        this.characteristicsDAO = new CharacteristicsDAO();
        this.categoriesDAO = new CategoriesDAO();
        this.productsDAO = new ProductsDAO();
    }

    public void categoriesSet(int id, String name, int pid ){
        CategoriesEntity categoriesEntity = new CategoriesEntity();

           // categoriesEntity.setCategoryId(id);
            categoriesEntity.setCatrgoryName(name);
            categoriesEntity.setParentId(BigInteger.valueOf(pid));

                this.categoriesSave(categoriesEntity, name);
    }

    public void categoriesSave(CategoriesEntity categoriesEntity, String name ) {
        categoriesDAO.save(categoriesEntity, name);

        this.myCategoriesEntity = categoriesEntity;

    }

    public void characteristicsSet(int id, String color, double size, double weight){
        CharacteristicsEntity characteristicsEntity = new CharacteristicsEntity();

        //    characteristicsEntity.setCharacteristicId(id);
            characteristicsEntity.setColor(color);
            characteristicsEntity.setSize(Double.valueOf(size));
            characteristicsEntity.setWeight(Double.valueOf(weight));


        this.characteristicsSave(characteristicsEntity, color);
    }

    public void characteristicsSave(CharacteristicsEntity characteristicsEntity, String name) {
        characteristicsDAO.save(characteristicsEntity, name);

        this.myCharacteristicsEntity = characteristicsEntity;

    }

    public void productsSet(int id, String name, int prize, boolean ava){
        ProductsEntity productsEntity = new ProductsEntity();

            productsEntity.setProductAvailability(ava);
        productsEntity.setPrize(BigInteger.valueOf(prize));
     //   productsEntity.setProductId(id);
        productsEntity.setName(name);

            productsEntity.setCategoriesByCategoryId(this.myCategoriesEntity);
            productsEntity.setCharacteristicsByCharacteristicId(this.myCharacteristicsEntity);



        this.productsSave(productsEntity, name);
    }

    public void productsSave(ProductsEntity productsEntity, String name) {productsDAO.save(productsEntity, name);}
}
