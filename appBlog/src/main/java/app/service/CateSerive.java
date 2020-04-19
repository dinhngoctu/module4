package app.service;

import app.model.Category;
import app.repository.ICateRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CateSerive implements ICateService {
    @Autowired
    ICateRepo cateRepoo;
    @Override
    public List<Category> findAll() {
        return cateRepoo.findAll();
    }

    @Override
    public void add(Category category) {
        cateRepoo.add(category);
    }

    @Override
    public void edit(Category category) {
    cateRepoo.edit(category);
    }

    @Override
    public void remove(Category category) {
        cateRepoo.remove(category);
    }

    @Override
    public Category findOne(Long id) {
       return cateRepoo.findOne(id);
    }
}
