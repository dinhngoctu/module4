package service.impl;

import model.Product;
import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.IProductRepo;
import service.ProductServiceInterFace;

import java.util.List;

public class ProductService implements ProductServiceInterFace {
    @Autowired
    IProductRepo iProductRepo;

    public ProductService() {
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }

    @Override
    public List<Product> findAllByProvince(Province province) {
        return (List<Product>) iProductRepo.findAllByProvince(province);
    }


    @Override
    public void revmove(Long id) {
    iProductRepo.deleteById(id);
    }

    @Override
    public void save(Product product) {
        if (product.getId()==null){
        iProductRepo.save(product);}
    }
}
