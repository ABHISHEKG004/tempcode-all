package MCothers.MarketPlaceFlipkart;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by shiva.b on 02/12/17.
 */
public class Utils {

  private static ObjectMapper objectMapper = new ObjectMapper();

  public static ObjectMapper getObjectMapper() {
    return objectMapper;
  }
}
