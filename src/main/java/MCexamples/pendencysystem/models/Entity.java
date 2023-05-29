package MCexamples.pendencysystem.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Entity {

    private final String entityId;
    private final List<Tags> tagsList;

    private EntityStatus entityStatus;


    public Entity(String entityId, List<Tags> tagsList) {
        this.entityId = entityId;
        this.tagsList = tagsList;
    }

    public void stopEntity(){
        this.entityStatus = EntityStatus.STOPPED;
    }

}
