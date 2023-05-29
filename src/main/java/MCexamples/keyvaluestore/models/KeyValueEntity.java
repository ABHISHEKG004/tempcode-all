package MCexamples.keyvaluestore.models;

import lombok.*;

import java.util.ArrayList;

/**
 * Created by Abhishek gupta on 2019-10-03
 */


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class KeyValueEntity {

  private String keyName;
  private ArrayList <AttributeEntity> attributes;

  public void addAttribute(AttributeEntity attributeEntity){
    this.attributes.add(attributeEntity);
  }

}
