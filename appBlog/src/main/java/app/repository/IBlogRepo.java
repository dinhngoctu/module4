package app.repository;


import app.model.Blog;
import app.model.Category;

import java.util.List;


public interface IBlogRepo extends IGeneralRepo<Blog> {
    List<Blog> findByCategory(int idCategory);
}
