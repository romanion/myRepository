package shop;

/**
 * Created by Роман on 05.11.2016.
 */
public class ProductsEntity {
    private Long productId;
    private Long prize;
    private Long productAvailability;
    private String name;
    private CharacteristicsEntity characteristicsByCharacteristicId;
    private CategoriesEntity categoriesByCategoryId;
    private BookingsEntity bookingsByBookingId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPrize() {
        return prize;
    }

    public void setPrize(Long prize) {
        this.prize = prize;
    }

    public Long getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(Long productAvailability) {
        this.productAvailability = productAvailability;
    }

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

    public CharacteristicsEntity getCharacteristicsByCharacteristicId() {
        return characteristicsByCharacteristicId;
    }

    public void setCharacteristicsByCharacteristicId(CharacteristicsEntity characteristicsByCharacteristicId) {
        this.characteristicsByCharacteristicId = characteristicsByCharacteristicId;
    }

    public CategoriesEntity getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(CategoriesEntity categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    public BookingsEntity getBookingsByBookingId() {
        return bookingsByBookingId;
    }

    public void setBookingsByBookingId(BookingsEntity bookingsByBookingId) {
        this.bookingsByBookingId = bookingsByBookingId;
    }
}
