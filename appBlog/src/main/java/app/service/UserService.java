package app.service;

import app.model.User;
import app.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements IUserService {
    @Autowired
    IUserRepo userRepo;

    @Override
    public User findByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public void add(User user) {
        userRepo.add(user);
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
