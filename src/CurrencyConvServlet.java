import javax.jws.WebMethod;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Alexey on 08.03.17.
 */
@WebServlet("CurrencyConvServlet")
public class CurrencyConvServlet extends HttpServlet {
    private enum Currency  {USD, EUR, RUR};

    private Currency from;
    private Currency to;
    private float sumFrom;
    private float sumTo;

    private final float usdRate = 58.26f;
    private final float eurRate = 61.71f;

    @Override
    @WebMethod(action = "POST")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        from = Currency.USD;
        to = Currency.RUR;
        sumFrom = 1.00f;
        sumTo = usdRate;
        response.setCharacterEncoding("UTF-8");
        outPage(response.getWriter());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        from = Currency.USD;
        to = Currency.RUR;
        sumFrom = 1.00f;
        sumTo = usdRate;
        response.setCharacterEncoding("UTF-8");
        outPage(response.getWriter());
    }

    private void outPage(PrintWriter printWriter) {
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"ru\">");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset=\"UTF-8\">");
        printWriter.println("       <title>Лешкин с Вовкой супер currency converter</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <h1>Лешкин с Вовкой супер currency converter в виде Java Servlet</h1>");
        printWriter.println("       <form action=\"CurrencyConvServlet.html\" method=\"post\">");
        printWriter.println("           <input type=\"text\" name=\"sum_from\" value=\"" + sumFrom + "\" size=\"20\" maxlength=\"15\" required>&nbsp;");
        printWriter.println("           <input type=\"radio\" name=\"from\" value=\"USD\"" + ((from == Currency.USD) ? " checked" : "") + ">USD</input>&nbsp;");
        printWriter.println("           <input type=\"radio\" name=\"from\" value=\"EUR\"" + ((from == Currency.EUR) ? " checked" : "") + ">EUR</input>&nbsp;");
        printWriter.println("           <input type=\"radio\" name=\"from\" value=\"RUR\"" + ((from == Currency.RUR) ? " checked" : "") + ">Руб</input>&nbsp;&nbsp;&nbsp;");
        printWriter.println("           =&nbsp;&nbsp;&nbsp;");
        printWriter.println("           <input type=\"text\" name=\"sum_to\" value=\"" + sumTo + "\" size=\"20\" readonly>&nbsp;");
        printWriter.println("           <input type=\"radio\" name=\"to\" value=\"USD\"" + ((to == Currency.USD) ? " checked" : "") + ">USD</input>&nbsp;");
        printWriter.println("           <input type=\"radio\" name=\"to\" value=\"EUR\"" + ((to == Currency.EUR) ? " checked" : "") + ">EUR</input>&nbsp;");
        printWriter.println("           <input type=\"radio\" name=\"to\" value=\"RUR\"" + ((to == Currency.RUR) ? " checked" : "") + ">Руб</input>&nbsp;");
        printWriter.println("           <br>");
        printWriter.println("           <input type=\"submit\" value=\"...\">");
        printWriter.println("       </form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }
}


