package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;
import by.niitzi.bushylo.v3.entity.Client;
import by.niitzi.bushylo.v3.service.ClientService;
import by.niitzi.bushylo.v3.service.impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.util.List;

public class ToAllClientsCommand implements Command {

    private ClientService clientService = ClientServiceImpl.getInstance();

    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, by.niitzi.bushylo.v3.exception.ServiceException {
        List<Client> allClients = clientService.findAllClients();

        CommandResult commandResult = new CommandResult("WEB-INF/jsp/admin/admin_show_all_users.jsp", CommandResult.ResponseType.FORWARD);
        commandResult.addAttribute("users", allClients);
        return commandResult;
    }
}
