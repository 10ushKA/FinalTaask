package by.niitzi.bushylo.v3.filter;

import by.niitzi.bushylo.v3.entity.Role;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter {
    //private final Logger logger = LoggerFactory.getLogger(AdminFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        /*List<Role> roles = (List<Role>) req.getSession().getAttribute("userRoles");
        if (roles == null || !roles.contains(Role.ADMIN)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("home?command=to_admin_log_in");
            req.setAttribute("message", "You must log in before start");
            //logger.info("Not authorized user goes as admin");
            requestDispatcher.forward(req, res);
        } else {
            chain.doFilter(req, res);
        }*/
        System.out.println("Admin Filter");
        Role role = (Role) req.getSession().getAttribute("role");
        if(role==Role.ADMIN){
            chain.doFilter(req, res);
            return;
        }
        req.getRequestDispatcher("/WEB-INF/jsp/loginPage.jsp").forward(req, res);

    }
}
