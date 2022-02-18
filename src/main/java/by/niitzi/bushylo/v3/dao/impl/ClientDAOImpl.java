package by.niitzi.bushylo.v3.dao.impl;

import by.niitzi.bushylo.v3.dao.AdminDAO;
import by.niitzi.bushylo.v3.dao.ClientDAO;
import by.niitzi.bushylo.v3.dao.DAOFactory;
import by.niitzi.bushylo.v3.db.ConnectionPool;
import by.niitzi.bushylo.v3.entity.*;
import by.niitzi.bushylo.v3.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDAOImpl implements ClientDAO {

    private static final String FIND_ALL= "select a.id as id, a.first_name as first_name, a.last_name as last_name, b.id as user_id, b.username as username, b.password as password, b.status as status, b.role as role, c.id as params_id, c.weight as weight, c.height as height, c.age as age from client as a join \"user\" as b on a.user_id=b.id join client_params as c on a.id = c.client_id";
    private static final String FIND_CLIENT = FIND_ALL + " where b.username=?";
    private static final String FIND_CLIENT_TOLOGIN = "select a.id as id, a.username as username, a.password as password, a.status as status, 1 as role from \"user\" as a where a.role = 1 and a.username=?";
    private static final String CREATE_PARAMS = "insert into client_params(weight,height, age, client_id) values(?,?,?,?)";
    private static final String CREATE_CLIENT = "insert into client(user_id, first_name, last_name) values(?,?,?)";
    private static final String DELETE_CLIENT = "delete from client where id=?";
    private static final String UPDATE_PARAMS = "update client_params set";
    private static final String UPDATE_CLIENT = "update client set";
    private static ClientDAO clientDAO;

    private AdminDAO adminDAO = DAOFactory.getAdminDAO();

    private ClientDAOImpl(){}

    public static ClientDAO getInstance(){
        if(clientDAO == null){
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }

    @Override
    public Optional<Client> findClient(String username) {
        Client client = null;
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_CLIENT)){
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                client = parseClient(resultSet);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return Optional.ofNullable(client); //"Invalid user credentials";
    }

    @Override
    public Optional<Client> findClientToLogin(String username) {
        Client client = null;
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_CLIENT_TOLOGIN)){
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                client = parseUserClient(resultSet);
            }
        }catch (SQLException e){
            client = null;
            System.out.println(e);
        }
        return Optional.ofNullable(client);}

    private Client parseUserClient(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        int status = rs.getInt("status");
        int role = rs.getInt("role");
        Role userRole = parseRole(role);
        Status userStatus = parseStatus(status);
        return new Client(id, username, password, userStatus, userRole);
    }

    private Client parseClient(ResultSet rs) throws SQLException {
        int user_id = rs.getInt("user_id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        int status = rs.getInt("status");
        int role = rs.getInt("role");
        int id = rs.getInt("id");
        String first_name = rs.getString("first_name");
        String last_name = rs.getString("last_name");

        int params_id = rs.getInt("params_id");
        int weight = rs.getInt("weight");
        int height = rs.getInt("height");
        int age = rs.getInt("age");
        Parameters parameters = new Parameters(params_id, weight, height, age);
        return new Client(user_id, username, password, parseStatus(status), parseRole(role), id, first_name, last_name, parameters);

    }

    private Status parseStatus(int st){
        return Status.values()[st - 1];
    }

    private Role parseRole(int ro){
        return Role.values()[ro - 1];
    }

    @Override
    public Client createClient(Client client) throws DAOException {
        User user = adminDAO.createUser(client);
        Client client1 = createClient_client(client, user.getId());
        Parameters params = createParams(client.getParams(), client.getId());
        client1.getParams().setId(params.getId());
        return client1;
    }

    private Parameters createParams(Parameters parameters, int clientId){
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_PARAMS, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, parameters.getWeight());
            statement.setInt(2, parameters.getHeight());
            statement.setInt(3, parameters.getAge());
            statement.setInt(4, clientId);
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                parameters.setId(id);
            }else{

            }
            return parameters;

        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    private Client createClient_client(Client client, int userId){
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_CLIENT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, userId);
            statement.setString(2,client.getFirstName());
            statement.setString(3,client.getLastName());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                client.setId(id);
            }else{

            }
            return client;
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Client> findAllClients() {
        List<Client> clients = new ArrayList<>();
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                clients.add(parseClient(resultSet));
            }
        }catch (SQLException e){

        }
        return clients;
    }

    @Override
    public void deleteClient(int clientId) {
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT)){
            statement.setInt(1, clientId);
             statement.executeUpdate();

        }catch (SQLException e){

        }
    }

    @Override
    public void updateClient(Client client) {
        Optional<Client> clientFromDBOpt = findClient(client.getUsername());
        if(clientFromDBOpt.isEmpty()){
            //
        }
        Client clientFromDB = clientFromDBOpt.get();
        updateParams(client.getParams(), clientFromDB);
        adminDAO.updateAdmin(client, clientFromDB.getUserId());
        updateClient_client(client, clientFromDB);
    }

    private void updateClient_client(Client newClient, Client oldClient){
        String sql = UPDATE_CLIENT;
        List<String> params = new ArrayList<>();
        if(newClient.getFirstName()!=null && !newClient.getFirstName().isBlank()){
            sql+=" first_name=?";
            params.add(newClient.getFirstName());
        }
        if(newClient.getLastName()!=null && !newClient.getLastName().isBlank()){
            if(!params.isEmpty()){
                sql+=",";
            }
            sql+=" last_name=?";
            params.add(newClient.getLastName());
        }
        if(params.isEmpty()){
            return;
        }
        sql+=" where id=?";
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            for(int i = 0 ; i < params.size(); i++){
                statement.setString(i+1, params.get(i));
            }
            statement.setInt(params.size()+1, oldClient.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    private void updateParams(Parameters params, Client client){
        String sql=  UPDATE_PARAMS;
        List<Integer> p = new ArrayList<>();
        if(params.getAge()!=0){
            sql+=" age=?";
            p.add(params.getAge());
        }
        if(params.getHeight()!=0){
            if(!p.isEmpty()) {
                sql += ",";
            }
            sql+=" height=?";
            p.add(params.getHeight());
        }
        if(params.getWeight()!=0){
            if(!p.isEmpty()){
                sql+=",";
            }
            sql+=" weight = ?";
            p.add(params.getWeight());
        }
        if(p.isEmpty()){
            return;
        }
        sql+=" where client_id=?";
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            for(int i = 0 ; i < p.size(); i++){
                statement.setInt(i+1, p.get(i));
            }
            statement.setInt(p.size()+1, client.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
