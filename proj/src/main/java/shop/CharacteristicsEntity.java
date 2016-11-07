package shop;

/**
 * Created by Роман on 05.11.2016.
 */
public class CharacteristicsEntity {
    private Long characteristicId;
    private Long size1;
    private Long weight;
    private String color;

    public Long getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(Long characteristicId) {
        this.characteristicId = characteristicId;
    }

    public Long getSize1() {
        return size1;
    }

    public void setSize1(Long size1) {
        this.size1 = size1;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacteristicsEntity that = (CharacteristicsEntity) o;

        if (characteristicId != null ? !characteristicId.equals(that.characteristicId) : that.characteristicId != null)
            return false;
        if (size1 != null ? !size1.equals(that.size1) : that.size1 != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = characteristicId != null ? characteristicId.hashCode() : 0;
        result = 31 * result + (size1 != null ? size1.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
