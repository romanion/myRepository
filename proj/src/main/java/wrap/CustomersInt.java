package wrap;
import shop.*;
/**
 * Created by Роман on 05.11.2016.
 */
public interface CustomersInt {
    public void save(CustomersEntity customersEntity);
    public void delete(long id);
    public void update(CustomersEntity customersEntity);
    public  CustomersEntity getEntityById(long id);
}
