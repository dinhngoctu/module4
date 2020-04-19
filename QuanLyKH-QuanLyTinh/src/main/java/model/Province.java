package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "province")
public class Province {
    @Id
    @Column(name = "name")
    String name;
    @OneToMany(targetEntity = Product.class)
    List<Product> productList;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }

    public Province() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province(String name) {
        this.name = name;
    }
}
