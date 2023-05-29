package MCexamples.limiter.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by Abhishek gupta on 30/10/18
 */

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class HotelResponseDto {
  private List<Hotel> hotels;
}
