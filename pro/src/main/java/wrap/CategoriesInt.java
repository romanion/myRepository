package wrap;


import base.*;

import java.math.BigInteger;

/**
 * Created by Роман on 05.11.2016.
 */
public interface CategoriesInt {
    public void save(CategoriesEntity categoriesEntity, String name);
    public void delete(BigInteger id);
    public void update(CategoriesEntity categoriesEntity);
    public CategoriesEntity getEntityById(BigInteger id);

}
