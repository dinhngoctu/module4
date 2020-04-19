package app.repository;

import app.model.User;

public interface IUserRepo extends IGeneralRepo<User>{
    User findByName(String name);
}
