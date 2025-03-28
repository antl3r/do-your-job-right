package interfaces;

import java.util.List;
import java.util.UUID;

import abstracts.Entity;

public interface IRepository<T extends Entity> {
    boolean add(T entity);
    List<T> getAll();
    T findById(UUID id);
    boolean deleteById(UUID id);
    UUID getId(T entity);
}
