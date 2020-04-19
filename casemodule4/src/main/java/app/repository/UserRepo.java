package app.repository;

import app.model.User;
import app.myutil.MyUtil;
import app.repository.repoInterface.IUserRepo;

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
    public User add(User user) {
       String pass = MyUtil.encrytePassword(user.getPass());
       user.setPass(pass);
        System.out.println(user.getName());
        System.out.println(user.getPass());
        em.persist(user);
        return user;
    }
    @Transactional
    @Override
    public User edit(User user) {
        String pass = MyUtil.encrytePassword(user.getPass());
        user.setPass(pass);
        em.merge(user);
        return user;
    }
    @Transactional
    @Override
    public User remove(User user) {

        return user;
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

