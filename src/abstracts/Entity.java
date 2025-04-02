package abstracts;

import java.util.UUID;

public abstract class Entity {
    private UUID id;

    /**
     * Constructs an Entity with a random UUID.
     */
    public Entity() {
        this.id = UUID.randomUUID();
    }

    /**
     * Constructs an Entity with a custom UUID.
     * 
     * @param id The custom UUID for the entity.
     */
    public Entity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
