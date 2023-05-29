package MCothers.MarketPlaceFlipkart.pojo;

import com.design.lowlevel.others.MarketPlaceFlipkart.enums.Category;

/**
 * Created by shiva.b on 02/12/17.
 */
public class Product {

  private Integer id;
  private String name;
  private Category category;

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }
    Product product = (Product)o;
    return product.id.equals(this.id);
  }
  @Override
  public int hashCode() {
    return this.id;
  }

  public Category getCategory() {
    return category;
  }

  public Integer getId() {
    return id;
  }
}
