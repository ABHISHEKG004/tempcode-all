package MCothers.MarketPlaceFlipkart.pojo;

import com.design.lowlevel.others.MarketPlaceFlipkart.enums.UserStatus;

/**
 * Created by shiva.b on 02/12/17.
 */

public class User {

  private Integer id;
  private String name;
  private UserStatus userStatus;

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return user.id.equals(this.id);
  }
  @Override
  public int hashCode() {
    return this.id;
  }

  public Integer getId() {
    return id;
  }
}
