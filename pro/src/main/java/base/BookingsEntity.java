package base;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by Роман on 07.11.2016.
 */
@Entity
@Table(name = "BOOKINGS1", schema = "public", catalog = "postgres")
public class BookingsEntity {
    private BigInteger sum;
    private Date data;

    private long bookingId;

    private CustomersEntity customersByCustomerId;
    @Basic
    @Column(name = "SUM", nullable = true, precision = 0)
    public BigInteger getSum() {
        return sum;
    }

    public void setSum(BigInteger sum) {
        this.sum = sum;
    }


    @Basic
    @Column(name = "DATA", nullable = true)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }



    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "BOOKING_ID", nullable = false, precision = 0)
    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingsEntity that = (BookingsEntity) o;

        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

      //  if (bookingId != null ? !bookingId.equals(that.bookingId) : that.bookingId != null) return false;

        return true;
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    public CustomersEntity getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(CustomersEntity customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }
    @Override
    public int hashCode() {
        int result = sum != null ? sum.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);

       // result = 31 * result + (bookingId != null ? bookingId.hashCode() : 0);
        return result;
    }
}
