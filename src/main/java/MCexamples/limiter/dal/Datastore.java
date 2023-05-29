package MCexamples.limiter.dal;

import com.api.rate.limiter.models.Hotel;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/** Created by Abhishek gupta on 30/10/18 */
public class Datastore {

  private static final Logger logger = Logger.getLogger(Datastore.class);

  private static List<Hotel> hotels = new ArrayList<>();

  //Assuming we can get valid apiKeys from some datastore
  private static List<String> validApiKeys =
      Arrays.asList("apiKey1", "apiKey2", "apiKey3", "apiKey4", "apiKey5", "apiKey6", "apiKey7");

  private static HashMap<String, Long> apiKeyLastServedTimestamp = new HashMap<>();

  // Not used ArrayList because lookup time for an apiKey in the list can be O(n) in worst case
  // (when using list.contains(object)), So used hashmap instead.
  private static HashMap<String, Boolean> suspendedApiKeys = new HashMap<>();

  // Used static block to load the hotels from Db(csv file) , because static blocks are executed
  // when the JVM loads the class which occurs the first time it is referenced in code
  // OR
  // Another way could also be load the hotels from Db using ServletContextListener which runs our
  // code on context initialization before the web application is started
  static {
    init();
  }

  private static void init(){
    BufferedReader reader = null;
    try {

      String fileName = "hoteldb.csv";
      int noOfColumns = 4;

      ClassLoader classLoader = Datastore.class.getClassLoader();
      File file = new File(classLoader.getResource(fileName).getFile());
      reader = new BufferedReader(new FileReader(file));

      String line = reader.readLine();
      int lineCount = 0;

      while (line != null) {
        if (lineCount > 0 && !line.isEmpty()) {
          String[] data = line.split(",");
          if (data.length == noOfColumns) {
            Hotel hotel = new Hotel();
            hotel.setCityName(data[0]);
            hotel.setHotelId(Integer.valueOf(data[1]));
            hotel.setRoomType(data[2]);
            hotel.setPrice(Integer.valueOf(data[3]));
            hotels.add(hotel);
          }
        }
        line = reader.readLine();
        lineCount++;
      }
      logger.info("[Datastore.init] | Successfully loaded hotels from csv file");
    } catch (IOException ex) {
      logger.error("[Datastore.init] | unable to load hotels from csv file");
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          logger.error("[Datastore.init] | unable to close csv file BufferedReader");
        }
      }
    }
  }

  public static List<Hotel> getHotels() {
    return hotels;
  }

  public static List<String> getValidApiKeys() {
    return validApiKeys;
  }

  public static HashMap<String, Long> getApiKeyLastServedTimestamp() {
    return apiKeyLastServedTimestamp;
  }

  public static HashMap<String, Boolean> getSuspendedApiKeys() {
    return suspendedApiKeys;
  }
}
