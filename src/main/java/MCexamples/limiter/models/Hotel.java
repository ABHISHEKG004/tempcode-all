package MCexamples.limiter.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Abhishek gupta on 30/10/18
 */

@Getter
@NoArgsConstructor
@Setter
public class Hotel {

  private String cityName;
  private Integer hotelId;
  private String roomType;
  private Integer price;
}
