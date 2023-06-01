package MCexamples.keyvaluestore.services;

import MCexamples.keyvaluestore.exceptions.InvalidAttributeTypeException;
import MCexamples.keyvaluestore.models.AttributeEntity;

import java.util.ArrayList;

/**
 * Created by Abhishek gupta on 2019-10-03
 */

public interface KeyValueService {

  void addKeyValueEntity(String key, ArrayList<AttributeEntity> attributeEntities)
      throws InvalidAttributeTypeException;

  void deleteKeyValueEntity(String key);

  void getKeyValueEntity(String key);

  void getKeysForAttributeValue(String attributeName, Object attributeValue);


}
