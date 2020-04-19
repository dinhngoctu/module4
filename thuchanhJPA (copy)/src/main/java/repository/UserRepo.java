package repository;

import model.User;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class UserRepo implements IUserRepo {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List findAll() {
        TypedQuery<User> query = em.createQuery("select u from User u",User.class);
        return query.getResultList();
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public void save(Object model) {

    }

    @Override
    public void remove(Long id) {

    }
}
