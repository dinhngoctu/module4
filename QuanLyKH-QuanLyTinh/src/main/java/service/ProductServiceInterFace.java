package service;


import model.Product;
import model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductServiceInterFace {

    Page<Product> findAll(Pageable pageable);

    List<Product> findAllByProvince(Province province);

    void revmove(Long id);

    void save(Product product);
}
