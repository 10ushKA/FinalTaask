package by.niitzi.bushylo.v3.filter;

import by.niitzi.bushylo.v3.entity.Role;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/client/*")
public class ClientFilter extends HttpFilter {
    //private final Logger logger = LoggerFactory.getLogger(ClientFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        List<Role> roleList = (List<Role>) req.getSession().getAttribute("CLIENT");
        /*Client client = (Client) req.getSession().getAttribute("client");
        if (roleList == null || !roleList.contains(Role.CLIENT)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("home?command=to_join");
            req.setAttribute("message", "You must log in before start");
            //logger.info("Not authorized user goes as client");
            requestDispatcher.forward(req, res);
        }  else {
            chain.doFilter(req, res);
        }*/
        System.out.println("Client filtered");
        if(roleList!=null){
            chain.doFilter(req, res);
            return;
        }
        req.getRequestDispatcher("/WEB-INF/jsp/loginPage.jsp").forward(req, res);
    }


}
