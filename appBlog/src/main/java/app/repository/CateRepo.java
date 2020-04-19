package app.repository;

import app.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class CateRepo implements ICateRepo {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> query = em.createQuery("select c from Category c", Category.class);
//        try {
            return query.getResultList();
//        } catch (NoResultException e) {
//            return null;
//        }
    }
    @Transactional
    @Override
    public void add(Category category) {
        em.persist(category);
    }
    @Transactional
    @Override
    public void edit(Category category) {
        em.merge(category);
    }
    @Transactional
    @Override
    public void remove(Category category) {
        em.remove(category);
    }

    @Override
    public Category findOne(Long id) {
        TypedQuery<Category> query = em.createQuery("select c from Category c where c.id = : id",Category.class);
        query.setParameter("id", Long.valueOf(id));
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
