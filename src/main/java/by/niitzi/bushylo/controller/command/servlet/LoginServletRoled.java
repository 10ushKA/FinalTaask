package by.niitzi.bushylo.controller.command.servlet;
import by.niitzi.bushylo.model.dao.UserDAO;
import by.niitzi.bushylo.model.entity.UserAccount;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet(urlPatterns = "/login")
public class LoginServletRoled extends HttpServlet {

        public LoginServletRoled() {
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

           UserAccount userAccount = new UserAccount();


            userAccount.setLogin(login);
            userAccount.setPassword(password);

            UserDAO userDAO = new UserDAO();
            try {
                String userValidate = userDAO.findUser(userAccount);

                if (userValidate.equals("Admin_Role")) {

                    HttpSession session = request.getSession(); //Creating a session
                    session.setAttribute("Admin", login); //setting session attribute
                    request.setAttribute("login", login);

                    request.getRequestDispatcher("WEB-INF/jsp/admin.jsp").forward(request, response);


                } else if (userValidate.equals("User_Role")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("User", login);
                    request.setAttribute("login", login);

                    request.getRequestDispatcher("WEB-INF/jsp/user.jsp").forward(request, response);


                } else {
                    System.out.println("Error message = " + userValidate);
                    request.setAttribute("errMessage", userValidate);

                    request.getRequestDispatcher("WEB-INF/jsp/loginPage.jsp").forward(request, response);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello World");
        //request.getRequestDispatcher("WEB-INF/jsp/hello.jsp").forward(request, response);
        request.getRequestDispatcher("WEB-INF/jsp/loginPage.jsp").forward(request, response);
        request.getRequestDispatcher("WEB-INF/jsp/user.jsp").forward(request, response);
    }
}

