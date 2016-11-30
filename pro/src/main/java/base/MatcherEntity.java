package base;

import javax.persistence.*;

/**
 * Created by Роман on 27.11.2016.
 */
@Entity
@Table(name = "matcher1", schema = "public", catalog = "postgres")
public class MatcherEntity {
    private long matcherId;
    private ProductsEntity productsByProductId;
    private BookingsEntity bookingsByBookingId;

    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "matcher_id", nullable = false)
    public long getMatcherId() {
        return matcherId;
    }

    public void setMatcherId(long matcherId) {
        this.matcherId = matcherId;
    }

    @ManyToOne
    @JoinColumn(name = "Booking_id", referencedColumnName = "booking_id", nullable = false)
    public BookingsEntity getBookingsByBookingId() {
        return bookingsByBookingId;
    }

    public void setBookingsByBookingId(BookingsEntity bookingsByBookingId) {
        this.bookingsByBookingId = bookingsByBookingId;
    }

    @ManyToOne
    @JoinColumn(name = "Product_id", referencedColumnName = "PRODUCT_ID", nullable = false)
    public ProductsEntity getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(ProductsEntity productsByProductsId) {
        this.productsByProductId = productsByProductsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatcherEntity that = (MatcherEntity) o;

     //   if (matcherId != null ? !matcherId.equals(that.matcherId) : that.matcherId != null) return false;

        return true;
    }

//    @Override
//    public int hashCode() {
//        return matcherId != null ? matcherId.hashCode() : 0;
//    }
}
