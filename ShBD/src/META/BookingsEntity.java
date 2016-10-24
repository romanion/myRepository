package META;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Роман on 24.10.2016.
 */
@Entity
@Table(name = "BOOKINGS", schema = "SYSTEM", catalog = "")
public class BookingsEntity {
    private Long bookingId;
    private Long sum;
    private Time data;
    private Long customerId;

    @Id
    @Column(name = "BOOKING_ID")
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    @Basic
    @Column(name = "SUM")
    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "DATA")
    public Time getData() {
        return data;
    }

    public void setData(Time data) {
        this.data = data;
    }

    @Basic
    @Column(name = "CUSTOMER_ID")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingsEntity that = (BookingsEntity) o;

        if (bookingId != null ? !bookingId.equals(that.bookingId) : that.bookingId != null) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookingId != null ? bookingId.hashCode() : 0;
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }
}
