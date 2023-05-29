package MCexamples.limiter.controllers;

import com.api.rate.limiter.services.HotelService;
import com.api.rate.limiter.utils.ResponseUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Abhishek gupta on 28/10/18
 */

@WebServlet(name = "GetHotels", urlPatterns = "/hotels")
public class GetHotels extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    ResponseUtil.writeResponse(HotelService.getHotels(request), response);
  }
}
