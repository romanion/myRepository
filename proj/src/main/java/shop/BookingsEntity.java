package shop;

import org.hibernate.annotations.Table;

import java.sql.Time;

/**
 * Created by Роман on 05.11.2016.
 */
public class BookingsEntity {
    private Long sum;
    private Time data;
    private Long productId;
    private Long bookingId;

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Time getData() {
        return data;
    }

    public void setData(Time data) {
        this.data = data;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingsEntity that = (BookingsEntity) o;

        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (bookingId != null ? !bookingId.equals(that.bookingId) : that.bookingId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sum != null ? sum.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (bookingId != null ? bookingId.hashCode() : 0);
        return result;
    }
}
