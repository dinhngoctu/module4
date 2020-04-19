package app.repository;

import app.model.Blog;
import app.model.Category;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepo implements IBlogRepo {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public void add(Blog blog) {
        if (blog != null) {
            if (blog.getId() == null) {
                em.persist(blog);
            }
        }
    }
    @Override
    public void edit(Blog blog) {
            if (blog.getId() != null) {
                TypedQuery<Blog> query = em.createQuery("select b from Blog b where b.id= :id", Blog.class);
                query.setParameter("id", blog.getId());
                if (query.getSingleResult()!=null) {
                    em.merge(blog);
                }
            }
        }

    @Override
    public void remove(Blog blog) {
        em.remove(blog);
    }

    @Override
    public List<Blog> findByCategory(int idCategory) {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b where b.category.id=:id", Blog.class);
        query.setParameter("id",idCategory);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}