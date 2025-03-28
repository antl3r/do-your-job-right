package abstracts;

import java.util.UUID;

public abstract class Entity {
    private UUID id;

    public Entity() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
