package MCothers.MarketPlaceFlipkart.operation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiva.b on 02/12/17.
 */
public class OperationProvider {

  private Map<String, Operation> operationMap = new HashMap<>();

  public void register(String key, Operation operation) {
    operationMap.put(key, operation);
  }

  public Operation getOperation(String key) throws IllegalArgumentException {
    if (key == null || !operationMap.containsKey(key)) {
      throw new IllegalArgumentException("Operation not permitted");
    }
    return operationMap.get(key);
  }
}
