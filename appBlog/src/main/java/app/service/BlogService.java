package app.service;

import app.model.Blog;
import app.model.Category;
import app.repository.IBlogPageRepo;
import app.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public class BlogService implements IBLogService {
    @Autowired
    IBlogRepo blogRepo;
    @Autowired
    IBlogPageRepo blogPageRepo;

    public BlogService() {
    }

    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Page<Blog> findAllPage(Pageable pageable) {
        return blogPageRepo.findAll(pageable);
    }

    @Override
    public void add(Blog blog) {
        blogRepo.add(blog);
    }

    @Override
    public void edit(Blog blog) {
        blogRepo.edit(blog);
    }

    @Override
    public void remove(Blog blog) {
        blogRepo.remove(blog);
    }

    @Override
    public List<Blog> findByCategory(int idCategory) {
        return blogRepo.findByCategory(idCategory);
    }

}
