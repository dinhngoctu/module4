//package app.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//
//
//@Entity
//@Table(name = "role")
//public class Role implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<UserRole> getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(List<UserRole> userRoles) {
//        this.userRoles = userRoles;
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private long id;
//
//    @Column(name = "name", unique = true, nullable = false)
//    private String name;
//    @JsonIgnore
//    @OneToMany(mappedBy = "id")
//    private List<UserRole> userRoles;
//}
