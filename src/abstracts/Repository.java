package abstracts;

import interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Repository<T extends Entity> extends Entity implements IRepository<T> {
    protected List<T> entities = new ArrayList<>();

    @Override
    public boolean add(T entity) {
        return entities.add(entity);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public T findById(UUID id) {
        for (T entity : entities) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(UUID id) {
        return entities.removeIf(entity -> entity.getId().equals(id));
    }

    @Override
    public UUID getId(T entity) {
        return entity.getId();
    }
}
