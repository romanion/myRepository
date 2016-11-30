package base;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Роман on 07.11.2016.
 */
@Entity
@Table(name = "CUSTOMERS1", schema = "public", catalog = "postgres")

public class CustomersEntity {
    private long customerId;
    private String lastName;
    private String firstName;
    private Boolean adminMode;
    private String email;
    private String phone;
    private String password;


    @Id
    @Column(name = "CUSTOMER_ID", nullable = false, precision = 0)
    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Basic
    @Column(name = "ADMIN_MODE", nullable = false)
    public Boolean getAdminMode() {
        return adminMode;
    }

    public void setAdminMode(Boolean adminMode) {
        this.adminMode = adminMode;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE", nullable = false, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersEntity that = (CustomersEntity) o;

     //   if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (adminMode != null ? !adminMode.equals(that.adminMode) : that.adminMode != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = /*customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + */(lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (adminMode != null ? adminMode.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);

        return result;
    }
}
