package MCothers.MarketPlaceFlipkart.operation;


import MCothers.MarketPlaceFlipkart.DataStore;
import MCothers.MarketPlaceFlipkart.Utils;
import MCothers.MarketPlaceFlipkart.pojo.Product;
import MCothers.MarketPlaceFlipkart.pojo.User;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by shiva.b on 02/12/17.
 */
public class Purchase implements Operation {

  private DataStore dataStore;

  public Purchase(DataStore dataStore) {
    this.dataStore = dataStore;
  }

  public void execute(String request) throws Exception {
    ObjectMapper objectMapper = Utils.getObjectMapper();

    Product product = objectMapper.readValue(request, Product.class);
    User user = objectMapper.readValue(request, User.class);

    if(product == null || product.getId() == null) {
      throw new Exception("Illegal product");
    }
    if(user == null || user.getId() == null || dataStore.isIllegalUser(user)) {
      throw new Exception("Illegal user");
    }

    boolean productAvailability = dataStore.checkProductAvailability(product);
    if(productAvailability) {
      dataStore.buyProduct(user, product);
    } else {
      throw new Exception("Product Unavailable");
    }
  }
}
