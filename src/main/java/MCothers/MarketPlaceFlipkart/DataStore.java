package MCothers.MarketPlaceFlipkart;

import com.design.lowlevel.others.MarketPlaceFlipkart.enums.Category;
import com.design.lowlevel.others.MarketPlaceFlipkart.pojo.Product;
import com.design.lowlevel.others.MarketPlaceFlipkart.pojo.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shiva.b on 02/12/17.
 */
public class DataStore {

  private Map<Product, Integer> availableProduct;
  private Map<User, Map<Product, Integer>> boughtProducts;
  private Map<Category, Set<Product>> categorySetMap;
  private Map<Product, Integer> distinctUserPurchaseMap;
  private Map<Category, Product> bestSellingProductCategory;
  private Product bestSellingProduct;
  private Set<User> blackListedUsers;

  public DataStore() {
    availableProduct = new HashMap<>();
    boughtProducts = new HashMap<>();
    categorySetMap = new HashMap<>();
    distinctUserPurchaseMap = new HashMap<>();
    bestSellingProductCategory = new HashMap<>();
    blackListedUsers = new HashSet<>();
  }

  public void incrementAvailableProduct(Product product) {
    Integer count = availableProduct.get(product);
    if (count == null) {
      count = 1;
    } else {
      count++;
    }
    availableProduct.put(product, count);
    updateCategorySetMap(product);
  }

  public void updateCategorySetMap(Product product) {
    Set<Product> products = categorySetMap.get(product.getCategory());
    if (products == null) {
      products = new HashSet<>();
    }
    products.add(product);
    categorySetMap.put(product.getCategory(), products);
  }

  public void buyProduct(User user, Product product) {
    Map<Product, Integer> userProductMap = boughtProducts.get(user);

    if(userProductMap == null) {
      userProductMap = new HashMap<>();
    }
    Integer count = userProductMap.get(product);
    if(count == null) {
      count = 1;
    } else {
      count++;
    }
    userProductMap.put(product, count);
    boughtProducts.put(user, userProductMap);
    decrementProductCount(product);
    incrementDistinctUserPurchase(product, user);
    updateBestSellingCategory(product);
    updateBestSellingProduct(product);
  }

  private void updateBestSellingCategory(Product product) {
    Category category = product.getCategory();
    Integer productCount = distinctUserPurchaseMap.get(product);
    Integer productBestCountForCategory = distinctUserPurchaseMap.get(bestSellingProductCategory.get(category));
    if (productBestCountForCategory < productCount) {
      bestSellingProductCategory.put(category, product);
    }
  }

  private void incrementDistinctUserPurchase(Product product, User user) {
    Map<Product, Integer> productMap = boughtProducts.get(user);
    if (productMap != null && productMap.containsKey(product)) {
      return;
    }
    Integer count = distinctUserPurchaseMap.get(product);
    if (count == null) {
      count = 1;
    }
    else {
      count++;
    }
    distinctUserPurchaseMap.put(product, count);
  }

  private void updateBestSellingProduct(Product product) {
    Integer count = distinctUserPurchaseMap.get(product);
    Integer prevBestCount = distinctUserPurchaseMap.get(bestSellingProduct);

    if(prevBestCount < count) {
      bestSellingProduct = product;
    }
  }

  private void decrementProductCount(Product product) {
    Integer count = availableProduct.get(product);
    if (count == null) {
      count = 0;
    }
    else {
      count--;
    }
    availableProduct.put(product, count);
  }

  private void incrementProductCount(Product product) {
    Integer count = availableProduct.get(product);
    if (count == null) {
      count = 0;
    }
    else {
      count--;
    }
    availableProduct.put(product, count);
  }

  public boolean checkProductAvailability(Product product) {
    return availableProduct.containsKey(product);
  }

  public Product getBestProductFromCategory(Category category) {
    return bestSellingProductCategory.get(category);
  }

  public Product getBestSellingProduct() {
    return bestSellingProduct;
  }

  public boolean isIllegalUser(User user) {
    return blackListedUsers.contains(user);
  }

  public void blackList(User user) {
    blackListedUsers.add(user);
  }
}
