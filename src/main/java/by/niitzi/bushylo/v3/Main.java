package by.niitzi.bushylo.v3;

import by.niitzi.bushylo.v3.dao.ClientDAO;
import by.niitzi.bushylo.v3.dao.DAOFactory;
import by.niitzi.bushylo.v3.db.ConnectionPool;

public class Main {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.CONNECTION_POOL;

        ClientDAO clientDAO = DAOFactory.getClientDAO();


    }
}
