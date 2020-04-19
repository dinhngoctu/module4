package app.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Size(min = 6,max = 30,message = "Độ dài lớn nhất là 30, ít nhất là 6.")
    String name;

    @Column(name = "pass")
    @NotEmpty(message = "Không được để trống")
    String pass="1234";

    @JsonIgnore
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    List<UserRole> userRoles;

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

//    public List<UserRole> getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(List<UserRole> userRoles) {
//        this.userRoles = userRoles;
//    }


    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public User() {
    }
    public User(String name) {
        this.name = name;
    }
    public User(String name,String pass) {
        this.name = name;
        this.pass = pass;
    }
}
