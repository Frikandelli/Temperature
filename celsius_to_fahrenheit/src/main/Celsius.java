package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Celsius extends HttpServlet{
/** Example of a Servlet that gets an ISBN number and returns the book price
 */

    /**
     *
     */
    private class Quoter {
        public double getFahrenheit(String celsius) {
            double cel = Double.parseDouble(celsius);
            System.out.println(cel);
            System.out.println(celsius);
            double fahrenheit = (cel * ((9.0/5.0)) + 32.0);
            System.out.println(fahrenheit);
            return fahrenheit;
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
        String title = "Celsius";
        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE>" +
                "<LINK REL=STYLESHEET HREF=\"styles.css\">" +
                "</HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1>" + title + "</H1>\n" +
                "  <P>Temperature in celsius: " +
                request.getParameter("isbn") + "\n" +
                "  <P>Temperature in fahrenheit: " +
                (quoter.getFahrenheit(request.getParameter("isbn"))) +
                "</BODY></HTML>");
    }
}
