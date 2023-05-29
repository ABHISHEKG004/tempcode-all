package MCexamples.limiter.constants;

/**
 * Created by Abhishek gupta on 30/10/18
 */

public class Constants {

  public static final String INVALID_REQUEST_CITY_REQUIRED = "Invalid request, city required";
  public static final String USER_DOES_NOT_HAVE_PERMISSION = "User doesn't have permission";
  public static final String TOO_MANY_REQUESTS = "Too many requests";

  public static final String RATE_LIMIT_SUFFIX = ".rate.limit";
  public static final String GLOBAL_RATE_LIMIT = "global.rate.limit";
  public static final String API_SUSPENDED_TIME = "api.suspended.time";

  public static final Long DEFAULT_GLOBAL_RATE_LIMIT = 10000L;
  public static final Long DEFAULT_API_SUSPENDED_TIME = 300000L;

}
