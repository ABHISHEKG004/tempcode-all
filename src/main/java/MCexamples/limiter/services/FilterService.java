package MCexamples.limiter.services;

import com.api.rate.limiter.dal.Datastore;
import com.api.rate.limiter.utils.ConfigProperties;

import static com.api.rate.limiter.constants.Constants.*;

/**
 * Created by Abhishek gupta on 02/11/18
 */

public class FilterService {

  // Note : can also use synchronized keyword in below method here to prevent race conditions, but
  // it will become bottleneck and will decrease performance significantly
  // Have an idea which can prevent race conditions and also  won't affect the performance
  // that much but needs a discussion
  // Idea is like : create a separate object for each apiKey using singleton pattern and store it in
  // a map and then use that object as a monitor object in synchronized block where all the read
  // and update operation are being performed for that particular apikey in below code

  /**
   * Returns boolean value which indicate whether we should reject the request or forward it
   *
   * @param apiKey
   * @return
   */
  public static boolean rejectRequest(String apiKey) {

    boolean reject;
    Long currentTime = System.currentTimeMillis();
    Long lastTimeStamp = Datastore.getApiKeyLastServedTimestamp().get(apiKey);

    // Added null check because, if lastTimeStamp of this apiKey is null that
    // means this is the first time request is received with this apikey
    if (lastTimeStamp == null) {
      lastTimeStamp = 0L;
    }

    // Core logic for rate limiting
    // Two maps are used suspendedApiKeys and apiKeyLastServedTimestamp
    // suspendedApiKeys -> tell us whether apiKey has been suspended or not
    // apiKeyLastServedTimestamp -> tell us timestamp of last served request with the given apikey

    if (Datastore.getSuspendedApiKeys().get(apiKey) != null
        && Datastore.getSuspendedApiKeys().get(apiKey)) {
      if (currentTime - lastTimeStamp
          > getValueForKey(API_SUSPENDED_TIME, DEFAULT_API_SUSPENDED_TIME)) {
        Datastore.getApiKeyLastServedTimestamp().put(apiKey, currentTime);
        Datastore.getSuspendedApiKeys().put(apiKey, false);
        reject = false;
      } else {
        //not updating getApiKeyLastServedTimestamp map because request is not served
        reject = true;
      }
    } else {

      if (currentTime - lastTimeStamp > getRateLimitForApiKey(apiKey)) {
        Datastore.getApiKeyLastServedTimestamp().put(apiKey, currentTime);
        reject = false;
      } else {
        Datastore.getApiKeyLastServedTimestamp().put(apiKey, currentTime);
        Datastore.getSuspendedApiKeys().put(apiKey, true);
        reject = true;
      }
    }
    return reject;
  }

  private static Long getRateLimitForApiKey(String apiKey) {
    String propertyName = apiKey + RATE_LIMIT_SUFFIX;
    String propertyValue = ConfigProperties.getProperty(propertyName);
    if (propertyValue == null) {
      return getValueForKey(GLOBAL_RATE_LIMIT, DEFAULT_GLOBAL_RATE_LIMIT);
    } else {
      return Long.parseLong(propertyValue);
    }
  }

  private static Long getValueForKey(String key, Long defaultValue) {
    String propertyValue = ConfigProperties.getProperty(key);
    if (propertyValue != null) {
      return Long.parseLong(propertyValue);
    }
    return defaultValue;
  }
}
