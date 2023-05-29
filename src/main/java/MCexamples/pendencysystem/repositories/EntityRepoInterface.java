package MCexamples.pendencysystem.repositories;


import MCexamples.pendencysystem.models.Entity;

public interface EntityRepoInterface {

    public Entity getEntityById(String entityId);
    public void addNewEntity(Entity entity);
    public void stopEntityTracking(String entityId);
}
