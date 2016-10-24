package META;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Роман on 24.10.2016.
 */
public class ProdutsEntityPK implements Serializable {
    private Long productId;
    private Long characteristicId;
    private Long categoryId;
    private Long bookingId;

    @Column(name = "PRODUCT_ID")
    @Id
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name = "CHARACTERISTIC_ID")
    @Id
    public Long getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(Long characteristicId) {
        this.characteristicId = characteristicId;
    }

    @Column(name = "CATEGORY_ID")
    @Id
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "BOOKING_ID")
    @Id
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

        ProdutsEntityPK that = (ProdutsEntityPK) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (characteristicId != null ? !characteristicId.equals(that.characteristicId) : that.characteristicId != null)
            return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (bookingId != null ? !bookingId.equals(that.bookingId) : that.bookingId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (characteristicId != null ? characteristicId.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (bookingId != null ? bookingId.hashCode() : 0);
        return result;
    }
}
