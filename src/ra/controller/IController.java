package ra.controller;

import java.util.List;

public interface IController<E,T> {
    void create(E e);
    void update(E e);
    void delete(T t);
    List<E> getAll();
    E findById(T t);
}
