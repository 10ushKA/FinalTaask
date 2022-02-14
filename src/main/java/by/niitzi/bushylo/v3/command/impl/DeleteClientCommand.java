package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;
import by.niitzi.bushylo.v3.entity.Client;
import by.niitzi.bushylo.v3.service.ClientService;
import by.niitzi.bushylo.v3.service.impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.util.Optional;

public class DeleteClientCommand implements Command {
    private ClientService clientService = ClientServiceImpl.getInstance();
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, by.niitzi.bushylo.v3.exception.ServiceException {
        String username = servletRequest.getParameter("username");
        Optional<Client> clientOpt = clientService.findClient(username);
        if(clientOpt.isEmpty()){
            //
        }
        Client client = clientOpt.get();

        clientService.deleteClient(client.getId());

        return new CommandResult("admin?command=to_admin_home", CommandResult.ResponseType.REDIRECT);
    }
}
