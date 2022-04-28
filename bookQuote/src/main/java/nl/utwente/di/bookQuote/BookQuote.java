package nl.utwente.di.bookQuote;

import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

/** Example of a Servlet that gets an ISBN number and returns the book price
 */

public class BookQuote extends HttpServlet {
 	/**
	 * 
	 */
    private class Quoter {
        HashMap<String, Double> priceList = new HashMap<String, Double>();
        public Quoter() {
            priceList.put("1", 10.0);
            priceList.put("2", 45.0);
            priceList.put("3", 20.0);
            priceList.put("4", 35.0);
            priceList.put("5", 50.0);
        }
        public double getBookPrice(String str) {

            double ret = priceList.get(str);
            return ret;
        }
    }
	private static final long serialVersionUID = 1L;
	private Quoter quoter;
	
    public void init() throws ServletException {
    	quoter = new Quoter();
    }	
	
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
      "<!DOCTYPE HTML>\n";
    String title = "Book Quote"; 
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE>" +
                "<LINK REL=STYLESHEET HREF=\"styles.css\">" +
                		"</HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1>" + title + "</H1>\n" +              
                "  <P>ISBN number: " +
                   request.getParameter("isbn") + "\n" +
                "  <P>Price: " +
                   Double.toString(quoter.getBookPrice(request.getParameter("isbn"))) +
                "</BODY></HTML>");
  }
  

}
