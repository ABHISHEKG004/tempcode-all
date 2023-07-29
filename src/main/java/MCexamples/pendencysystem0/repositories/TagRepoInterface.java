package MCexamples.pendencysystem0.repositories;


import MCexamples.pendencysystem0.models.Entity;
import MCexamples.pendencysystem0.models.Tags;

import java.util.List;

public interface TagRepoInterface {

    public int getTagCount(List<Tags> tags);
    public void addTagToRepo(Entity entity);

    public void removeTagCount(Entity entity);

}
