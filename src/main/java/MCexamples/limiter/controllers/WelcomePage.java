package MCexamples.limiter.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Abhishek gupta on 04/11/18
 */

@WebServlet(name = "WelcomePage", urlPatterns = "/")
public class WelcomePage extends HttpServlet {
  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    response.getWriter().print("<html><body>");
    response.getWriter().print("<h3>Welcome!!!</h3>");
    response.getWriter().print("</body></html>");
  }
}