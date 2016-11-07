package wrap;


import shop.*;
/**
 * Created by Роман on 05.11.2016.
 */
public interface CatigoriesInt {
    public void save(CategoriesEntity categoriesEntity);
    public void delete(long id);
    public void update(CategoriesEntity categoriesEntity);
    public CategoriesEntity getEntityById(long id);

}
