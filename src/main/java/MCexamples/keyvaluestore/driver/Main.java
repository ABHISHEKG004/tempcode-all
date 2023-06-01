package MCexamples.keyvaluestore.driver;

import MCexamples.keyvaluestore.exceptions.InvalidAttributeTypeException;
import MCexamples.keyvaluestore.models.AttributeEntity;
import MCexamples.keyvaluestore.services.KeyValueService;
import MCexamples.keyvaluestore.services.KeyValueSimpleService;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Abhishek gupta on 2019-10-03
 */

public class Main {

  public static void main(String[] args) throws InvalidAttributeTypeException {

    KeyValueService keyValueSimpleService = new KeyValueSimpleService();


    AttributeEntity attributeEntity1 = new AttributeEntity("pollution_level", "very_high");
    AttributeEntity attributeEntity2 = new AttributeEntity("population", "10 million");
    AttributeEntity attributeEntity3 = new AttributeEntity("free_food", false);
    AttributeEntity attributeEntity10 = new AttributeEntity("address", Arrays.asList("line1", "line2"));
    ArrayList<AttributeEntity> attributeEntities1 = new ArrayList<AttributeEntity>();
    attributeEntities1.add(attributeEntity1);
    attributeEntities1.add(attributeEntity2);
    attributeEntities1.add(attributeEntity3);
    attributeEntities1.add(attributeEntity10);


    //adding a key value item
    try{
      keyValueSimpleService.addKeyValueEntity("delhi",attributeEntities1);
    }catch (Exception e){
      System.out.println(e);
    }

    //getting a key value item
    keyValueSimpleService.getKeyValueEntity("delhi");

    //deleting a key value item
    keyValueSimpleService.deleteKeyValueEntity("delhi");

    //getting a key value item
    keyValueSimpleService.getKeyValueEntity("delhi");


    AttributeEntity attributeEntity4 = new AttributeEntity("pollution_level", "moderate");
    AttributeEntity attributeEntity5 = new AttributeEntity("latitude", 23.45);
    AttributeEntity attributeEntity6 = new AttributeEntity("free_food", "yes");
    ArrayList<AttributeEntity> attributeEntities2 = new ArrayList<AttributeEntity>();
    attributeEntities2.add(attributeEntity4);
    attributeEntities2.add(attributeEntity5);
    attributeEntities2.add(attributeEntity6);

    //adding a key value item when one attribute type doesn't match
    try{
      keyValueSimpleService.addKeyValueEntity("bangalore",attributeEntities2);
    }catch (Exception e){
      System.out.println(e);
    }


    AttributeEntity attributeEntity7 = new AttributeEntity("pollution_level", "less");
    AttributeEntity attributeEntity8 = new AttributeEntity("latitude", 27.45);
    AttributeEntity attributeEntity9 = new AttributeEntity("free_food", false);
    AttributeEntity attributeEntity11 = new AttributeEntity("address", Arrays.asList(1, 2));
    ArrayList<AttributeEntity> attributeEntities3 = new ArrayList<AttributeEntity>();
    attributeEntities3.add(attributeEntity7);
    attributeEntities3.add(attributeEntity8);
    attributeEntities3.add(attributeEntity9);
    attributeEntities3.add(attributeEntity11);

    //adding a key value item
    try{
      keyValueSimpleService.addKeyValueEntity("meerut",attributeEntities3);
    }catch (Exception e){
      System.out.println(e);
    }

    keyValueSimpleService.getKeysForAttributeValue("free_food", false);

  }
}
