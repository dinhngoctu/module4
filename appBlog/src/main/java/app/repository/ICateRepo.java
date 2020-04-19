package app.repository;

import app.model.Category;

public interface ICateRepo extends IGeneralRepo<Category> {
    Category findOne(Long id);
}
