package MCexamples.pendencysystem0.repositories;


import MCexamples.pendencysystem0.models.Entity;

public interface EntityRepoInterface {

    public Entity getEntityById(String entityId);
    public void addNewEntity(Entity entity);
    public void stopEntityTracking(String entityId);
}
