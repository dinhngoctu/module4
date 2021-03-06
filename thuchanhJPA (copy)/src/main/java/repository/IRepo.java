package repository;

import java.util.List;

public interface IRepo<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
