package MCexamples.limiter.constants;

/**
 * Created by Abhishek gupta on 30/10/18
 */

public enum OrderByEnum {
  ASCENDING("0"),
  DESCENDING("1");

  private String code;

  OrderByEnum(String code){
    this.code = code;
  }

  public static OrderByEnum getValue(String value) {
    for (OrderByEnum e : OrderByEnum.values()) {
      if (e.code.equals(value)) {
        return e;
      }
    }
    return null;
  }

}
