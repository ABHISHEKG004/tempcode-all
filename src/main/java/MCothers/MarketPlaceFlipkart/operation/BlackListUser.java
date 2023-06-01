package MCothers.MarketPlaceFlipkart.operation;


import MCothers.MarketPlaceFlipkart.DataStore;
import MCothers.MarketPlaceFlipkart.Utils;
import MCothers.MarketPlaceFlipkart.pojo.User;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by shiva.b on 02/12/17.
 */
public class BlackListUser implements Operation {

  private DataStore dataStore;

  public BlackListUser(DataStore dataStore) {
    this.dataStore = dataStore;
  }

  public void execute(String request) throws Exception {
    ObjectMapper objectMapper = Utils.getObjectMapper();
    User user = objectMapper.readValue(request, User.class);

    if(user == null || user.getId() == null) {
      throw new Exception("ILLegal User");
    }
    dataStore.blackList(user);
  }
}
