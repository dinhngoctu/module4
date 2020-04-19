package app.service;

import app.model.Blog;
import app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBLogService {
    public List<Blog> findAll();

    Page<Blog> findAllPage(Pageable pageable);

    void add(Blog blog);

    void edit(Blog blog);

    void remove(Blog blog);

    List<Blog> findByCategory(int idCategory);
}
