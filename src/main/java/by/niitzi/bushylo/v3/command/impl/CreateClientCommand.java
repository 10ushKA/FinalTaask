package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;
import by.niitzi.bushylo.v3.entity.*;
import by.niitzi.bushylo.v3.service.ClientService;
import by.niitzi.bushylo.v3.service.impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import by.niitzi.bushylo.v3.exception.ServiceException;

public class CreateClientCommand implements Command {

    private ClientService clientService = ClientServiceImpl.getInstance();

    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        String first_name = servletRequest.getParameter("first_name");
        String last_name = servletRequest.getParameter("last_name");
        Integer weight = Integer.parseInt(servletRequest.getParameter("weight"));
        Integer height = Integer.parseInt(servletRequest.getParameter("height"));
        Integer age = Integer.parseInt(servletRequest.getParameter("age"));
        Parameters parameters = new Parameters(weight, height, age);
        Client client = new Client(username, password, Status.ACTIVE, Role.CLIENT, first_name, last_name, parameters);
        clientService.createClient(client);

        return new CommandResult("admin?command=to_admin_home", CommandResult.ResponseType.REDIRECT);
    }
}
