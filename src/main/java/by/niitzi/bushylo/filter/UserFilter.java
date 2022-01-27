package by.niitzi.bushylo.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/user/*")
public class UserFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user!=null){
            chain.doFilter(req, res);
            return;
        }
        req.getRequestDispatcher("/WEB-INF/jsp/loginPage.jsp").forward(req, res);
    }
}
