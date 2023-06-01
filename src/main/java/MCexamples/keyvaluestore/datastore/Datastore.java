package MCexamples.keyvaluestore.datastore;

import MCexamples.keyvaluestore.models.AttributeMetaInfo;
import MCexamples.keyvaluestore.models.KeyValueEntity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Abhishek gupta on 2019-10-03
 */

public class Datastore {

  private static HashMap<String, KeyValueEntity> keyValueData = new HashMap<String, KeyValueEntity>();

  private static HashMap<String, AttributeMetaInfo> attributeMetaInfoData = new HashMap<String,
      AttributeMetaInfo>();

  private static HashMap<String, ArrayList<String>> attributeValueWiseKeys = new HashMap<String,
      ArrayList<String>>();

  //KeyValueData operations
  public static KeyValueEntity getKeyData(String keyName){
    return keyValueData.get(keyName);
  }

  public static void putKeyData(String keyName, KeyValueEntity data){
     keyValueData.put(keyName, data);
  }

  public static void removeKeyData(String keyName){
    keyValueData.remove(keyName);
  }

  //AttributeMetaInfoData operations
  public static AttributeMetaInfo getAttributeMetaInfoData(String attributeName){
    return attributeMetaInfoData.get(attributeName);
  }

  public static void putAttributeMetaInfoData(String attributeName, AttributeMetaInfo data){
    attributeMetaInfoData.put(attributeName, data);
  }

  //AttributeValueWiseKeys operations
  public static ArrayList<String> getAttributeValueWiseKeys(String attributeValueKey){

    return attributeValueWiseKeys.get(attributeValueKey);
  }

  public static void putAttributeValueWiseKeys(String attributeValueKey, String key){
    if(attributeValueWiseKeys.get(attributeValueKey)==null){
      attributeValueWiseKeys.put(attributeValueKey, new ArrayList<String>());
    }
    attributeValueWiseKeys.get(attributeValueKey).add(key);
  }

  public static void removeAttributeValueWiseKeys(String attributeValueKey, String key){
    attributeValueWiseKeys.get(attributeValueKey).remove(key);
  }

}
