package MCexamples.limiter.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.api.rate.limiter.constants.HeaderConstants.*;

/**
 * Created by Abhishek gupta on 30/10/18
 */

public class ResponseUtil {

  private static final Logger logger = Logger.getLogger(ResponseUtil.class);

  public static void writeResponse(String json, HttpServletResponse response) {
    writeJsonResponse(json,response);
  }

  private static void writeJsonResponse(String json, HttpServletResponse response) {
    try {

      setHeader(response, CONTENT_TYPE, APPLICATION_JSON);
      setHeader(response, CONTENT_LENGTH, String.valueOf(json.length()));
      response.getWriter().write(json);
      response.getWriter().flush();
    } catch (IOException e) {
      logger.error("[ResponseUtil.writeJsonResponse] | IOException while writing to client", e);
    }
  }

  private static void setHeader(HttpServletResponse response, String header, String value ) {
    response.setHeader(header, value);
  }

}
