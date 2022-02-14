package by.niitzi.bushylo.v3.dao.impl;

import by.niitzi.bushylo.v3.dao.AdminDAO;
import by.niitzi.bushylo.v3.db.ConnectionPool;
import by.niitzi.bushylo.v3.entity.Role;
import by.niitzi.bushylo.v3.entity.Status;
import by.niitzi.bushylo.v3.entity.User;
import by.niitzi.bushylo.v3.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminDAOImpl implements AdminDAO {
    private static AdminDAO adminDAO;
    private static final String FIND_ADMIN_SQL = "select a.id as id, a.username as username, a.password as password, a.status as status, 2 as role from \"user\" as a where a.role = 2 and a.username=?";
    private static final String CREATE_ADMIN_SQL = "insert into \"user\"(username, password, status, role) values (?, ?, ?, ?)";
    private static final String UPDATE_ADMIN_SQL = "update \"user\" set";

    private AdminDAOImpl(){}

    public static AdminDAO getInstance(){
        if(adminDAO == null){
            adminDAO = new AdminDAOImpl();
        }
        return adminDAO;
    }

    @Override
    public Optional<User> findAdmin(String username) {
        User user = null;
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ADMIN_SQL)){
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                user = parseUser(resultSet);
            }
        }catch (SQLException e){
            user = null;
            System.out.println(e);
        }
        return Optional.ofNullable(user);
    }

    private User parseUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        int status = rs.getInt("status");
        int role = rs.getInt("role");
        Role userRole = parseRole(role);
        Status userStatus = parseStatus(status);
        return new User(id, username, password, userStatus, userRole);
    }

    private Role parseRole(int role){
        return Role.values()[role - 1];
    }

    private Status parseStatus(int st){
        return Status.values()[st - 1];
    }

    @Override
    public User createUser(User user) throws DAOException {
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_ADMIN_SQL, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getStatus().ordinal()+ 1);
            statement.setInt(4, user.getRole().ordinal()+1);
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                user.setId(id);
            }else{
                throw new DAOException("Not created");
            }
            return user;
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }


    @Override
    public boolean updateAdmin(User user, int userId) {
        List<Object> params = new ArrayList<>();
        String sql = UPDATE_ADMIN_SQL;
        if(user.getUsername()!=null && user.getUsername().isBlank()){
            sql+=" username = ?";
            params.add(user.getUsername());
        }

        if(user.getPassword()!=null && !user.getPassword().isBlank()){
            if(!params.isEmpty()){
                sql+=",";
            }
            sql+=" password = ?";
            params.add(user.getPassword());
        }

        if(user.getStatus()!=null){
            if(!params.isEmpty()){
                sql+=",";
            }

            sql+=" status = ?";
            params.add(user.getStatus().ordinal()+1);
        }
        sql+=" where id=?";

        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            for(int i = 0 ; i < params.size(); i++){
                Object param = params.get(i);
                if(param instanceof String){
                    statement.setString(i+1, (String) param);
                }else{
                    statement.setInt(i+1, (Integer) param);
                }
            }
            statement.setInt(params.size()+1, userId);
            return statement.execute();
        }catch (SQLException e){
        }

        return false;
    }
}
