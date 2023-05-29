package MCexamples.splitwise.models;

import lombok.*;

import java.util.ArrayList;

/**
 * Created by Abhishek gupta on 2019-09-17
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

  private String id;
  private String name;
  private String email;
  private ArrayList<String> groupIds;

}
