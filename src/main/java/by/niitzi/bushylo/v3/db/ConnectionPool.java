package by.niitzi.bushylo.v3.db;

import by.niitzi.bushylo.v3.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionPool {
    private final ConcurrentLinkedQueue<Connection> availableConnection = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<Connection> usedConnections = new ConcurrentLinkedQueue<>();

    private final int initSize = ApplicationProperties.APPLICATION_PROPERTIES.getInitSize();
    private final int maxSize = ApplicationProperties.APPLICATION_PROPERTIES.getMaxSize();

    private final String dbUrl = ApplicationProperties.APPLICATION_PROPERTIES.getDbUrl();
    private final String login = ApplicationProperties.APPLICATION_PROPERTIES.getLogin();
    private final String password = ApplicationProperties.APPLICATION_PROPERTIES.getPassword();
    private final String dbDriver = ApplicationProperties.APPLICATION_PROPERTIES.getDbDriver();

    private ConnectionPool(){
    }

    public static final ConnectionPool CONNECTION_POOL = new ConnectionPool();

    public Connection getConnection(){
        Connection connection;
        if(availableConnection.isEmpty() && (availableConnection.size() + usedConnections.size() + 5 < maxSize)){
            for (int i = 0 ; i < 5; i++){
                addConnection();
            }
        }

        connection = availableConnection.poll();
        usedConnections.add(connection);
        return connection;
    }

    public void init() throws ClassNotFoundException {
        Class.forName(dbDriver);
        for(int i = 0 ; i < initSize; i++){
            addConnection();
        }
    }

    private Connection addConnection(){
        Connection connection = null;
        try {
            connection = new ConnectionProxy(DriverManager.getConnection(dbUrl, login, password));
        } catch (SQLException exception){
            System.out.println(exception);
        }

        availableConnection.add(connection);
        return connection;
    }

    public void returnConnection(Connection connection){
        usedConnections.remove(connection);
        availableConnection.add(connection);
    }

    public void closeAll() throws SQLException {
        for(Connection connection : availableConnection){
            ((ConnectionProxy) connection).realClose();
        }

        for(Connection connection : usedConnections){
            ((ConnectionProxy) connection).realClose();
        }
    }
}
