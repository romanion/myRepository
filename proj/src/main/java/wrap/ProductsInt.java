package wrap;
import shop.*;
/**
 * Created by Роман on 05.11.2016.
 */
public interface ProductsInt {

    public void save(ProductsEntity productsEntity);
    public void delete(long id);
    public void update(ProductsEntity productsEntity);
    public  ProductsEntity getEntityById(long id);
}
