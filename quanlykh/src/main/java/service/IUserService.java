package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findOne(Long id);

    User save(User customer);

    List<User> save(List<User> customers);

    boolean exists(Long id);

    List<User> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(User customer);

    void delete(List<User> customers);

    void deleteAll();
}
