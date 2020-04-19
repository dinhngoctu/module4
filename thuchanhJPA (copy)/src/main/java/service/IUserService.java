package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(String name);

    void save(User customer);

    void remove(Long id);
}
