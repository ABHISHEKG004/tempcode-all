package MCexamples.keyvaluestore.models;

import lombok.*;

/**
 * Created by Abhishek gupta on 2019-10-03
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class AttributeEntity {

  private String name;
  private Object value;
}
