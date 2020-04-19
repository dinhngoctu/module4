package app.repository;

import java.util.List;

public interface IGeneralRepo<T> {
    List<T> findAll();

    void add(T t);

    void edit(T t);

    void remove(T t);

}
