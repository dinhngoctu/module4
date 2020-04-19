package service;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;

public class UserService implements IUserService {

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(new File("/home/bbt/Downloads/quanlykh/src/main/resources/hibernate.cfg.xml"));
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            sessionFactory.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public User save(User customer) {
        return null;
    }

    @Override
    public List<User> save(List<User> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(User customer) {

    }

    @Override
    public void delete(List<User> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
