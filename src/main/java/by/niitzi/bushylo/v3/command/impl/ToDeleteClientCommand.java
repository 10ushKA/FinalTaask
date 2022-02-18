package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import by.niitzi.bushylo.v3.exception.ServiceException;

public class ToDeleteClientCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException {
        return new CommandResult("WEB-INF/jsp/admin/admin_delete_user.jsp", CommandResult.ResponseType.FORWARD);
    }
}
