package ra.model.services;

import java.util.List;

public interface IServices<E,T> {
    void create(E e);
    void update(E e);
    void delete(T t);
    List<E> getAll();
    E findById(T t);
}
