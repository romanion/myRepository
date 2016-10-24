package META;

import javax.persistence.*;

/**
 * Created by Роман on 24.10.2016.
 */
@Entity
@Table(name = "PRODUTS", schema = "SYSTEM")
@IdClass(ProdutsEntityPK.class)
public class ProdutsEntity {
    private Long productId;
    private Long characteristicId;
    private Long price;
    private Long productAvailability;
    private Long categoryId;
    private Long bookingId;

    @Id
    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "CHARACTERISTIC_ID")
    public Long getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(Long characteristicId) {
        this.characteristicId = characteristicId;
    }

    @Basic
    @Column(name = "PRICE")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "PRODUCT_AVAILABILITY")
    public Long getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(Long productAvailability) {
        this.productAvailability = productAvailability;
    }

    @Id
    @Column(name = "CATEGORY_ID")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Id
    @Column(name = "BOOKING_ID")
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

        ProdutsEntity that = (ProdutsEntity) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (characteristicId != null ? !characteristicId.equals(that.characteristicId) : that.characteristicId != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (productAvailability != null ? !productAvailability.equals(that.productAvailability) : that.productAvailability != null)
            return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (bookingId != null ? !bookingId.equals(that.bookingId) : that.bookingId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (characteristicId != null ? characteristicId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (productAvailability != null ? productAvailability.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (bookingId != null ? bookingId.hashCode() : 0);
        return result;
    }
}
