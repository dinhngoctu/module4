package app.service;


import app.model.Category;

import java.util.List;

public interface ICateService {
    public List<Category> findAll();
    void add(Category category);

    void edit(Category category);

    void remove(Category category);

    Category findOne(Long id);
}
