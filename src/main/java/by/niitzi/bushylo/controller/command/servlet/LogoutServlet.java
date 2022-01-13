package by.niitzi.bushylo.controller.command.servlet;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServlet requst, HttpServlet response) throws ServletException, IOException {
        super.doGet((HttpServletRequest) requst, (HttpServletResponse) response);
        HttpSession session = ((HttpServletRequest) requst).getSession(false);
        if (session != null){
            session.removeAttribute("user");

            RequestDispatcher dispatcher = ((HttpServletRequest) requst).getRequestDispatcher("WEB-INF/jsp/loginPage.jsp");
            dispatcher.forward((ServletRequest) requst, (ServletResponse) response);
        }

    }
}
