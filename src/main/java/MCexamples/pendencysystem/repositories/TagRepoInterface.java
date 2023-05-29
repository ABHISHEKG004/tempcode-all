package MCexamples.pendencysystem.repositories;


import MCexamples.pendencysystem.models.Entity;
import MCexamples.pendencysystem.models.Tags;

import java.util.List;

public interface TagRepoInterface {

    public int getTagCount(List<Tags> tags);
    public void addTagToRepo(Entity entity);

    public void removeTagCount(Entity entity);

}
