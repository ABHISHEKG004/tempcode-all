package MCexamples.limiter.services;

import com.api.rate.limiter.constants.Constants;
import com.api.rate.limiter.constants.OrderByEnum;
import com.api.rate.limiter.dal.Repository;
import com.api.rate.limiter.models.Hotel;
import com.api.rate.limiter.models.HotelResponseDto;
import com.api.rate.limiter.utils.ObjectMapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.api.rate.limiter.constants.RequestParamsConstants.CITY;
import static com.api.rate.limiter.constants.RequestParamsConstants.ORDER_BY;

/** Created by Abhishek gupta on 30/10/18 */
public class HotelService {

  private static final Logger logger = Logger.getLogger(HotelService.class);

  public static String getHotels(HttpServletRequest request) throws JsonProcessingException {

    String cityName = request.getParameter(CITY);
    if (cityName == null) {
      return Constants.INVALID_REQUEST_CITY_REQUIRED;
    }

    String orderByFlag = request.getParameter(ORDER_BY);
    OrderByEnum orderBy = OrderByEnum.getValue(orderByFlag);

    String response =
        ObjectMapperUtil.objectMapperUtil.writeValueAsString(getHotels(cityName, orderBy));
    logger.info("[HotelService.getHotels] | response : " + response);

    return response;
  }

  /**
   * Returns list of hotels on the basis of city name and order by price(optional)
   *
   * @param city
   * @param orderBy
   * @return
   */
  private static HotelResponseDto getHotels(String city, OrderByEnum orderBy) {

    List<Hotel> hotels = Repository.getHotelsByCity(city);

    if (OrderByEnum.ASCENDING.equals(orderBy)) {
      hotels.sort((Hotel a1, Hotel a2) -> a1.getPrice() - a2.getPrice());
    } else if (OrderByEnum.DESCENDING.equals(orderBy)) {
      hotels.sort((Hotel a1, Hotel a2) -> a2.getPrice() - a1.getPrice());
    }
    return new HotelResponseDto(hotels);
  }
}
