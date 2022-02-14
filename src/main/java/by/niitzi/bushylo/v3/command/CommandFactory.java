package by.niitzi.bushylo.v3.command;

public class CommandFactory {
    public static Command command(String command) {
        Command temp = null;
        if (command != null) {
            try {
                temp = CommandType.valueOf(command.toUpperCase().replaceAll("-", "_")).getCommand();
            } catch (IllegalArgumentException e) {
                temp = CommandType.TO_HOME.getCommand();
            }
        }
        //home?command=to-home
        //admin?command=to-admin-home // TO_ADMIN_HOME
        //client?command=to_client_home
        return temp != null ? temp : CommandType.TO_HOME.getCommand();
    }
}
