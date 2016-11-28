package intdao;

import base.BookingsEntity;

import java.math.BigInteger;


/**
 * Created by Роман on 05.11.2016.
 */
public interface BookingInt {

    public void save(BookingsEntity bookingEntity);
    public void delete(long id);
    public void update(BookingsEntity bookingEntity);
    public BookingsEntity getEntityById(long id);


}
