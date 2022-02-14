package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

public class LogoutCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException {
        servletRequest.getSession().invalidate();
        return new CommandResult("home?command=to_loginPage", CommandResult.ResponseType.REDIRECT);
    }
}
