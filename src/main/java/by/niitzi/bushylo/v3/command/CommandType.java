package by.niitzi.bushylo.v3.command;

import by.niitzi.bushylo.v3.command.impl.*;

public enum CommandType {
    TO_HOME(new ToHomeCommand()),
    TO_LOGIN(new ToLoginCommand()),
    LOG_IN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    TO_CLIENT_HOME(new ToClientHomeCommand()),
    TO_ADMIN_HOME(new ToAdminHomeCommand()),
    TO_ALL_CLIENTS(new ToAllClientsCommand()),
    TO_CREATE_CLIENT(new ToCreateClientCommand()),
    CREATE_CLIENT(new CreateClientCommand()),
    TO_DELETE_CLIENT(new ToDeleteClientCommand()),
    DELETE_CLIENT(new DeleteClientCommand()),
    TO_UPDATE_CLIENT(new ToUpdateClientCommand()),
    UPDATE_CLIENT(new UpdateClientCommand()),
    ;


    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
