package base;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Роман on 07.11.2016.
 */
@Entity
@Table(name = "CHARACTERISTICS1", schema = "public", catalog = "postgres")
public class CharacteristicsEntity {
    private long characteristicId;
    private Double size;
    private String color;
    private Double weight;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "CHARACTERISTIC_ID", nullable = false, precision = 0)
    public long getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(long characteristicId) {
        this.characteristicId = characteristicId;
    }

    @Basic
    @Column(name = "SIZE", nullable = false, precision = 0)
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Basic
    @Column(name = "COLOR", nullable = false, length = -1)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "WEIGHT", nullable = false, precision = 0)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacteristicsEntity that = (CharacteristicsEntity) o;

     /*   if (characteristicId != null ? !characteristicId.equals(that.characteristicId) : that.characteristicId != null)
            return false;*/
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = /*characteristicId != null ? characteristicId.hashCode() : 0;
        result = 31 * result +*/ (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }
}
