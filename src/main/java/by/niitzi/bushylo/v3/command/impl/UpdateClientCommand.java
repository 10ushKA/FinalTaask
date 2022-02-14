package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;
import by.niitzi.bushylo.v3.entity.Client;
import by.niitzi.bushylo.v3.entity.Parameters;
import by.niitzi.bushylo.v3.entity.Role;
import by.niitzi.bushylo.v3.entity.Status;
import by.niitzi.bushylo.v3.service.impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

public class UpdateClientCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, by.niitzi.bushylo.v3.exception.ServiceException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        String first_name = servletRequest.getParameter("first_name");
        String last_name = servletRequest.getParameter("last_name");
        Integer weight = Integer.parseInt(servletRequest.getParameter("weight").isBlank()?"0":servletRequest.getParameter("weight"));
        Integer height = Integer.parseInt(servletRequest.getParameter("height").isBlank()?"0":servletRequest.getParameter("height"));
        Integer age = Integer.parseInt(servletRequest.getParameter("age").isBlank()?"0":servletRequest.getParameter("age"));
        Parameters parameters = new Parameters(weight, height, age);
        Client client = new Client(username, password, Status.ACTIVE, Role.CLIENT, first_name, last_name, parameters);
        ClientServiceImpl.getInstance().updateClient(client);
        return new CommandResult("admin?command=to_admin_home", CommandResult.ResponseType.REDIRECT);
    }
}
