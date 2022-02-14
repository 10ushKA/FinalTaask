package by.niitzi.bushylo.v3.command.impl;

import by.niitzi.bushylo.v3.command.Command;
import by.niitzi.bushylo.v3.command.CommandResult;

import javax.servlet.http.HttpServletRequest;

public class ToHomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) {
        return new CommandResult("WEB-INF/jsp/homePage.jsp", CommandResult.ResponseType.FORWARD);
    }
}
