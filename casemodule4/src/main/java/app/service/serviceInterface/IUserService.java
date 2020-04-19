package app.service.serviceInterface;

import app.model.User;

import java.util.List;

public interface IUserService {
    User findByName(String name);

    void add(User user);

    void edit(User user);

    void remove(User user);

    List<User> findAll();
}
