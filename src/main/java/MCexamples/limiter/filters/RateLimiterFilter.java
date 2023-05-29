package MCexamples.limiter.filters;


import com.api.rate.limiter.constants.Constants;
import com.api.rate.limiter.dal.Datastore;
import com.api.rate.limiter.services.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.api.rate.limiter.constants.RequestParamsConstants.API_KEY;

/**
 * Created by Abhishek gupta on 30/10/18
 */


@WebFilter(urlPatterns = {"/*"})
public class RateLimiterFilter implements Filter {

  public void init(FilterConfig config) throws ServletException {}

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    String apiKey = request.getParameter(API_KEY);

    if (!Datastore.getValidApiKeys().contains(apiKey)) {
      ((HttpServletResponse) response)
          .sendError(HttpServletResponse.SC_UNAUTHORIZED, Constants.USER_DOES_NOT_HAVE_PERMISSION);
      return;
    }

    if (FilterService.rejectRequest(apiKey)) {
      ((HttpServletResponse) response)
          .sendError(HttpServletResponse.SC_FORBIDDEN, Constants.TOO_MANY_REQUESTS);
      return;
    }

    chain.doFilter(request, response);
  }

  public void destroy( ) {}
}