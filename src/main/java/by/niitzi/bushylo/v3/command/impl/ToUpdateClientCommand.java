package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

public class ToUpdateClientCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, by.niitzi.bushylo.v3.exception.ServiceException {
        return new CommandResult("WEB-INF/jsp/admin/admin_update_user.jsp", CommandResult.ResponseType.FORWARD);
    }
}
