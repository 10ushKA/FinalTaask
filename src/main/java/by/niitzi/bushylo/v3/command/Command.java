package by.niitzi.bushylo.v3.command;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

public interface Command {
    CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, by.niitzi.bushylo.v3.exception.ServiceException;
}
