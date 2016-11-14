package wrap;
import base.*;

import java.math.BigInteger;

/**
 * Created by Роман on 05.11.2016.
 */
public interface CustomersInt {
    public void save(CustomersEntity customersEntity);
    public void delete(BigInteger id);
    public void update(CustomersEntity customersEntity);
    public  CustomersEntity getEntityById(BigInteger id);
}
