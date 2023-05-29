package MCexamples.limiter.dal;

import com.api.rate.limiter.models.Hotel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Abhishek gupta on 30/10/18
 */

public class Repository {

  public static List<Hotel> getHotelsByCity(String city) {

    return Datastore.getHotels()
            .stream()
            .filter(hotel -> hotel.getCityName().equals(city))
            .collect(Collectors.toList());
  }
}
