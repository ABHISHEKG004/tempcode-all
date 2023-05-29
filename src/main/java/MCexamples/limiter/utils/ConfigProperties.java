package MCexamples.limiter.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Abhishek gupta on 31/10/18
 */

public class ConfigProperties {

  private static final Logger logger = Logger.getLogger(ConfigProperties.class);

  private static Properties prop;

  static {
    init();
  }

  private static void init() {
    prop = new Properties();
    InputStream input = null;

    try {

      input = ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties");
      prop.load(input);
      logger.info("[ConfigProperties.init] | Successfully loaded config properties");

    } catch (IOException ex) {
      logger.error("[ConfigProperties.init] | unable to load config properties");
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          logger.error("[ConfigProperties.init] | unable to close properties file inputstream");
        }
      }
    }
  }

  public static String getProperty(String key) {
    return prop.getProperty(key);
  }

}
