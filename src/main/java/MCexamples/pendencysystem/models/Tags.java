package MCexamples.pendencysystem.models;


import lombok.Getter;

@Getter
public class Tags {

    private final Enum tag;

    public Tags(Enum tag) {
        this.tag = tag;
    }
}
