package base;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Роман on 07.11.2016.
 */
@Entity
@Table(name = "CATEGORIES", schema = "public", catalog = "shop")
public class CategoriesEntity {
    private BigInteger categoryId;
    private String catrgoryName;
    private BigInteger parentId;

    @Id
    @Column(name = "CATEGORY_ID", nullable = false, precision = 0)
    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "CATRGORY_NAME", nullable = false, length = 20)
    public String getCatrgoryName() {
        return catrgoryName;
    }

    public void setCatrgoryName(String catrgoryName) {
        this.catrgoryName = catrgoryName;
    }

    @Basic
    @Column(name = "PARENT_ID", nullable = false, precision = 0)
    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriesEntity that = (CategoriesEntity) o;

        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (catrgoryName != null ? !catrgoryName.equals(that.catrgoryName) : that.catrgoryName != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (catrgoryName != null ? catrgoryName.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }
}
