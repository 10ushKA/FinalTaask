package by.niitzi.bushylo.v3.command;

import javax.servlet.http.HttpServletRequest;

import by.niitzi.bushylo.v3.exception.DAOException;
import by.niitzi.bushylo.v3.exception.ServiceException;

public interface Command {
    CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, DAOException;
}
