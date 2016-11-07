package base;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Роман on 07.11.2016.
 */
@Entity
@Table(name = "PRODUCTS", schema = "public", catalog = "shop")
public class ProductsEntity {
    private BigInteger productId;
    private BigInteger prize;
    private Boolean productAvailability;
    private String name;
    private CharacteristicsEntity characteristicsByCharacteristicId;
    private CategoriesEntity categoriesByCategoryId;
    private BookingsEntity bookingsByBookingId;

    @Id
    @Column(name = "PRODUCT_ID", nullable = false, precision = 0)
    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "PRIZE", nullable = false, precision = 0)
    public BigInteger getPrize() {
        return prize;
    }

    public void setPrize(BigInteger prize) {
        this.prize = prize;
    }

    @Basic
    @Column(name = "PRODUCT_AVAILABILITY", nullable = false)
    public Boolean getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(Boolean productAvailability) {
        this.productAvailability = productAvailability;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (prize != null ? !prize.equals(that.prize) : that.prize != null) return false;
        if (productAvailability != null ? !productAvailability.equals(that.productAvailability) : that.productAvailability != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (prize != null ? prize.hashCode() : 0);
        result = 31 * result + (productAvailability != null ? productAvailability.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CHARACTERISTIC_ID", referencedColumnName = "CHARACTERISTIC_ID", nullable = false)
    public CharacteristicsEntity getCharacteristicsByCharacteristicId() {
        return characteristicsByCharacteristicId;
    }

    public void setCharacteristicsByCharacteristicId(CharacteristicsEntity characteristicsByCharacteristicId) {
        this.characteristicsByCharacteristicId = characteristicsByCharacteristicId;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID", nullable = false)
    public CategoriesEntity getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(CategoriesEntity categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID", referencedColumnName = "BOOKING_ID", nullable = false)
    public BookingsEntity getBookingsByBookingId() {
        return bookingsByBookingId;
    }

    public void setBookingsByBookingId(BookingsEntity bookingsByBookingId) {
        this.bookingsByBookingId = bookingsByBookingId;
    }
}
