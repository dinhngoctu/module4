package service;

import model.User;

import repository.IUserRepo;

import java.util.List;


public class UserService implements IUserService {

    IUserRepo userRepo;

    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(String name) {
        return null;
    }

    @Override
    public void save(User customer) {

    }

    @Override
    public void remove(Long id) {

    }
}
