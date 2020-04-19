package app.repository;

import app.model.User;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


public class UserRepo implements IUserRepo {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void add(User user) {
        em.persist(user);
    }
    @Transactional
    @Override
    public void edit(User user) {
        em.merge(user);
    }
    @Transactional
    @Override
    public void remove(User user) {

    }

    @Override
    public User findByName(String name) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.name = :name", User.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        }catch(NoResultException n) {
                return null;}
    }
}

