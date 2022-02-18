package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;
import by.niitzi.bushylo.v3.command.CommandType;
import by.niitzi.bushylo.v3.entity.Client;
import by.niitzi.bushylo.v3.entity.Role;
import by.niitzi.bushylo.v3.entity.User;
import by.niitzi.bushylo.v3.exception.DAOException;
import by.niitzi.bushylo.v3.exception.ServiceException;
import by.niitzi.bushylo.v3.service.AdminService;
import by.niitzi.bushylo.v3.service.ClientService;
import by.niitzi.bushylo.v3.service.impl.AdminServiceImpl;
import by.niitzi.bushylo.v3.service.impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements Command {
    private AdminService adminService= AdminServiceImpl.getInstance();
    //private final Logger logger = LoggerFactory.getLogger(LoginCommand.class);
    private final ClientService clientService = ClientServiceImpl.getInstance();

    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, DAOException {
        String userName = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        Optional<Client> client = clientService.findClientToLogin(userName);
        if(client.isPresent() && client.get().getPassword().equals(password)){
            servletRequest.getSession().setAttribute("client", client.get());
            servletRequest.getSession().setAttribute("role", Role.CLIENT);
            return new CommandResult("client?command=to_client_home", CommandResult.ResponseType.REDIRECT);
        }
        Optional<User> admin = adminService.findAdmin(userName);
        if(admin.isPresent() && admin.get().getPassword().equals(password)){
            servletRequest.getSession().setAttribute("admin", admin.get());
            servletRequest.getSession().setAttribute("role", Role.ADMIN);
            return new CommandResult("admin?command=to_admin_home", CommandResult.ResponseType.REDIRECT);
        }else {
            System.out.println("Error message: the user tried to log in = " + admin);
            //servletRequest.setAttribute("errMessage", admin);
            servletRequest.setAttribute("errMessage", "\"Invalid user credentials\"");

            return  CommandType.TO_LOGIN.getCommand().execute(servletRequest);
        }
        //return CommandType.TO_LOGIN.getCommand().execute(servletRequest);
    }

   /* private CommandResult adminLogin(HttpServletRequest servletRequest, String userName, String password) throws ServiceException {
       CommandResult commandResult;
       String message;

       try{
           Optional<Client> userOptional = clientService.findClient(userName);
           if(userOptional.isPresent() && userOptional.get().getPassword().equals(password)){
               HttpSession session = servletRequest.getSession();
               session.setAttribute("role", userOptional.get().getRole());
               commandResult = new CommandResult("admin?command=to_admin_home", CommandResult.ResponseType.REDIRECT);
               session.setAttribute("ADMIN", userOptional.get());
               //logger.info("Admin logged successful");
               return commandResult;
           }//logger.info("Admin dont logged : Incorrect userName or password");
           message = "Incorrect username or password";
       } catch (ServiceException e) {
           //logger.error("Admin dont logged : "+e.getMessage());
           message = "Sorry, aliens attacked our server ... But they left some incomprehensible message : " + e + "...\n Please, try again later";
       }
        commandResult = new CommandResult("WEB-INF/jsp/loginPage.jsp", CommandResult.ResponseType.FORWARD);
        servletRequest.setAttribute("message", message);
        return commandResult;
       }

    private CommandResult clientLogin(HttpServletRequest servletRequest, String userName, String password) throws ServiceException {
        CommandResult commandResult;
        String message;

        try{
            Optional<Client> userOptional = clientService.findClient(userName);
            if(userOptional.isPresent() && userOptional.get().getPassword().equals(password)){
                HttpSession session = servletRequest.getSession();
                session.setAttribute("role", userOptional.get().getRole());
                commandResult = new CommandResult("client?command=to_client_home", CommandResult.ResponseType.REDIRECT);
                session.setAttribute("CLIENT", userOptional.get());
                //logger.info("Admin logged successful");
                return commandResult;
            }//logger.info("Admin dont logged : Incorrect userName or password");
            message = "Incorrect username or password";
        } catch (ServiceException e) {
            //logger.error("Admin dont logged : "+e.getMessage());
            message = "Sorry, aliens attacked our server ... But they left some incomprehensible message : " + e + "...\n Please, try again later";
        }
        commandResult = new CommandResult("WEB-INF/jsp/loginPage.jsp", CommandResult.ResponseType.FORWARD);
        servletRequest.setAttribute("message", message);
        return commandResult;
    }*/

}

