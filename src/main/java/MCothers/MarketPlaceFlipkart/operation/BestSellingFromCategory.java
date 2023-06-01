package MCothers.MarketPlaceFlipkart.operation;


import MCothers.MarketPlaceFlipkart.DataStore;
import MCothers.MarketPlaceFlipkart.Utils;
import MCothers.MarketPlaceFlipkart.enums.Category;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by shiva.b on 02/12/17.
 */
public class BestSellingFromCategory implements Operation {

  private DataStore dataStore;

  public BestSellingFromCategory(DataStore dataStore) {
    this.dataStore = dataStore;
  }

  public void execute(String request) throws IOException {
    ObjectMapper objectMapper = Utils.getObjectMapper();
    Category category = objectMapper.readValue(request, Category.class);
    System.out.println(dataStore.getBestProductFromCategory(category));
  }
}
