package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

public class ToAdminHomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException {
        return new CommandResult("WEB-INF/jsp/admin/admin_home.jsp", CommandResult.ResponseType.FORWARD);
    }
}
