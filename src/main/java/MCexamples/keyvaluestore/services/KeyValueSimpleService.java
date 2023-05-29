package MCexamples.keyvaluestore.services;

import com.design.keyvaluestore.datastore.Datastore;
import com.design.keyvaluestore.exceptions.InvalidAttributeTypeException;
import com.design.keyvaluestore.models.AttributeEntity;
import com.design.keyvaluestore.models.AttributeMetaInfo;
import com.design.keyvaluestore.models.KeyValueEntity;

import java.util.ArrayList;

/**
 * Created by Abhishek gupta on 2019-10-03
 */

public class KeyValueSimpleService implements KeyValueService{

  public synchronized void addKeyValueEntity(String key, ArrayList<AttributeEntity> attributeEntities)
      throws InvalidAttributeTypeException {

    KeyValueEntity keyValueEntity = new KeyValueEntity(key, new ArrayList<AttributeEntity>());

    validateAttributeEntities(attributeEntities);

    for(AttributeEntity attributeEntity : attributeEntities){

      String name = attributeEntity.getName();
      Object value = attributeEntity.getValue();
      String typeOfValue = value.getClass().getName();

      //add attribute data to key value entity
      keyValueEntity.addAttribute(attributeEntity);

      //add attribute meta info to datastore if not present
      AttributeMetaInfo attributeMetaInfo = Datastore.getAttributeMetaInfoData(name);
      if(attributeMetaInfo==null){
        Datastore.putAttributeMetaInfoData(name, new AttributeMetaInfo(name, typeOfValue));
      }

      //add attribute value wise data in datastore
      Datastore.putAttributeValueWiseKeys(getAttributeValueKey(name, value), key);

    }

    //add key value item in datastore
    Datastore.putKeyData(key, keyValueEntity);
    System.out.println("data for key " + key + " successfully added");
    System.out.println();
  }

  private void validateAttributeEntities(ArrayList<AttributeEntity> attributeEntities)
      throws InvalidAttributeTypeException {

    for(AttributeEntity attributeEntity : attributeEntities){

      String name = attributeEntity.getName();
      Object value = attributeEntity.getValue();
      String typeOfValue = value.getClass().getName();

      AttributeMetaInfo attributeMetaInfo = Datastore.getAttributeMetaInfoData(name);

      if(attributeMetaInfo!=null && !attributeMetaInfo.getType().equals(typeOfValue)){
        throw new InvalidAttributeTypeException("attribute " + name + " must have type " + attributeMetaInfo.getType());
      }
    }
  }

  public void deleteKeyValueEntity(String key){

    KeyValueEntity keyValueEntity = Datastore.getKeyData(key);
    if(keyValueEntity!=null){
      Datastore.removeKeyData(key);

      ArrayList<AttributeEntity> attributeEntities = keyValueEntity.getAttributes();
      for(AttributeEntity attributeEntity : attributeEntities){
        String name = attributeEntity.getName();
        Object value = attributeEntity.getValue();
        Datastore.removeAttributeValueWiseKeys(getAttributeValueKey(name, value), key);
      }

      System.out.println("Deleted key " + key + " succesfully");
    } else {

      System.out.println("Key " + key + " already deleted");
    }
    System.out.println();
  }

  public void getKeyValueEntity(String key){
    KeyValueEntity keyValueEntity = Datastore.getKeyData(key);
    if(keyValueEntity==null){
      System.out.println("No key value item found for key : " + key);
    } else {
      System.out.println("Key value item found");
      System.out.println(keyValueEntity);
    }
    System.out.println();
  }

  public void getKeysForAttributeValue(String attributeName, Object attributeValue){

    ArrayList<String> keys = Datastore.getAttributeValueWiseKeys(getAttributeValueKey(attributeName, attributeValue));

    System.out.println("Keys : ");
    System.out.println(keys);

    if(!keys.isEmpty()){
      System.out.println();
      System.out.println("Details of keys value item :");
    }
    for(String key : keys){
      System.out.println(Datastore.getKeyData(key));
    }
    System.out.println();
  }

  public String getAttributeValueKey(String attributeName, Object attributeValue){
    String attributeValueKey = attributeName + "-" + attributeValue;
    return attributeValueKey;
  }

  //  private synchronized void addKeyValueMethodLevelLock() {
//
//
//  }

//  private void addKeyValueObjectLevelLock() {
//  }
}
