package MCexamples.pendencySystem.entity;

import MCexamples.pendencySystem.enums.TrackingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Entity {
    private String id;
    private CTag firstCTag;
    private TrackingStatus isTracked ;

    private List<Tag> tagList ;

    public Entity(String id, CTag ctag, List<Tag> tagList) {
        this.id = id ;
        this.firstCTag = ctag;
        this.tagList = tagList;
        this.isTracked = TrackingStatus.ACTIVE;
    }

    public void startTracking() {
        this.isTracked = TrackingStatus.ACTIVE;
    }

    public void stopTracking() {
        this.isTracked = TrackingStatus.INACTIVE;
    }
}
