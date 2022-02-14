package by.niitzi.bushylo.v3.dao.impl;

import by.niitzi.bushylo.v3.dao.WardrobeDAO;
import by.niitzi.bushylo.v3.db.ConnectionPool;
import by.niitzi.bushylo.v3.entity.Item;
import by.niitzi.bushylo.v3.entity.Type;
import by.niitzi.bushylo.v3.entity.Wardrobe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WardrobeDAOImpl implements WardrobeDAO {

    private static final String CREATE_WARDROBE = "insert into wardrobe(client_id, name, volume) values(?,?,?)";
    private static final String FIND_ALL_WARDROBE = "select id, client_id, name, volume from wardrobe";
    private static final String FIND_WARDROBE = FIND_ALL_WARDROBE + " where client_id= ?" ;
    private static final String FIND_ALL_ITEMS = "select a.id as id, a.color as color, b.id as type_id, b.name as type_name, a.size as size, a.creator as creator from item a join item_type b on a.type_id= b.id";
    private static final String FIND_WARDROBE_ITEMS =  FIND_ALL_ITEMS + " where wardrobe_id = ?";
    private static final String DELETE_WARDROBE = "delete from wardrobe where id = ?";
    private static final String CREATE_ITEM = "insert into item(wardrobe_id, color, type_id, size, creator) values(?,?,?,?,?)";
    private static final String UPDATE_ITEM = "update item set";
    private static final String DELETE_ITEM = "delete from item where id = ?";
    private static final String UPDATE_WARDROBE = "update wardrobe set";
    //private static final String CREATE_ITEM_TYPE = "insert into item_type(name, item_id) values(?,?)";

    private static WardrobeDAO wardrobeDAO;

    private WardrobeDAOImpl(){}

    public static WardrobeDAO getInstance(){
        if(wardrobeDAO == null){
            wardrobeDAO = new WardrobeDAOImpl();
        }
        return wardrobeDAO;
    }

    @Override
    public Wardrobe createWardrobe(Wardrobe wardrobe, int clientId) {
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_WARDROBE)){
            statement.setInt(1, clientId);
            statement.setString(2, wardrobe.getName());
            statement.setInt(3, wardrobe.getVolume());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int id = generatedKeys.getInt("id");
            wardrobe.setId(id);
            return wardrobe;
        }catch (SQLException e){

        }
        return null;
    }

    @Override
    public Wardrobe findWardrobe(int clientId) {
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_WARDROBE)) {
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                Wardrobe wardrobe = parseWardrobe(resultSet);
                updateWardrobeItems(wardrobe);
                return wardrobe;
            }
        }catch (SQLException e){

        }
        return null;
    }

    private void updateWardrobeItems(Wardrobe wardrobe){
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_WARDROBE_ITEMS)){
            statement.setInt(1, wardrobe.getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                wardrobe.getItems().add(parseItem(resultSet));
            }
        }catch (SQLException e){

        }
    }

    private Item parseItem(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String color = rs.getString("color");
        int type_id = rs.getInt("type_id");
        String type_name = rs.getString("type_name");
        String  size = rs.getString("size");
        String designer = rs.getString("designer");

        Type type = new Type(type_id, type_name);
        return new Item(id, color, type, size, designer);
    }

    private Wardrobe parseWardrobe(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int volume = rs.getInt("volume");
        return new Wardrobe(id, name, volume, new ArrayList<>());
    }

    @Override
    public List<Wardrobe> findAll() {
        List<Wardrobe> wardrobes = new ArrayList<>();
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_ALL_WARDROBE)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                wardrobes.add(parseWardrobe(resultSet));
            }
        }catch (SQLException e){

        }
        return wardrobes;
    }

    @Override
    public boolean deleteWardrobe(int wardrobeId) throws SQLException {
        boolean rowDeleted;

        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_WARDROBE)){
            statement.setInt(1, wardrobeId);
            rowDeleted = statement.executeUpdate() > 0;
        }

        return rowDeleted;
    }

    @Override
    public boolean updateWardrobe(Wardrobe wardrobe) {
        List<Object> wardrobeList = new ArrayList<>();
        String sql = UPDATE_WARDROBE;
        if(wardrobe.getName()!=null && wardrobe.getName().isBlank()){
            sql+= "name = ?";
            wardrobeList.add(wardrobe.getName());
        }

        if(wardrobe.getVolume()!= 0){
            if(!wardrobeList.isEmpty()){
                sql+=",";
            }
            sql+= "volume = ?";
            wardrobeList.add(wardrobe.getVolume());
        }
        return false;
    }

    @Override
    public Item createItem(Item item, int wardrobeId, int typeId) {
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
        PreparedStatement statement = connection.prepareStatement(CREATE_ITEM)){
            statement.setInt(1, wardrobeId);
            statement.setString(2, item.getColor());
            statement.setInt(3,typeId);
            statement.setString(4, item.getSize());
            statement.setString(5, item.getCreator());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int id = generatedKeys.getInt("id");
            item.setId(id);
            return item;
        }catch (SQLException e){}
        return null;
    }

   /* private Type createItemType(Type type, int itemId){
        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_ITEM_TYPE)){
            statement.setString(1, type.getName());
            statement.setInt(2, itemId);
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int id = generatedKeys.getInt("id");
            type.setId(id);
            return type;
        }catch (SQLException e){}
        return null;
    }*/

    @Override
    public boolean deleteItem(int itemId) throws SQLException {
        boolean rowDeleted;

        try(Connection connection = ConnectionPool.CONNECTION_POOL.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ITEM)){
            statement.setInt(1, itemId);
            rowDeleted = statement.executeUpdate() > 0;
        }

        return rowDeleted;
    }

    @Override
    public boolean updateItem(Item item) {
        List<Object> items = new ArrayList<>();
        String sql = UPDATE_ITEM;
        if(item.getColor()!=null && item.getColor().isBlank()){
            sql+= "color = ?";
            items.add(item.getColor());
        }

        if(item.getSize()!=null && item.getSize().isBlank()){
            if(!items.isEmpty()){
                sql+=",";
            }
            sql+= "size = ?";
            items.add(item.getSize());
        }

        if(item.getCreator()!=null && item.getCreator().isBlank()){
            if(!items.isEmpty()){
                sql+=",";
            }
            sql+= "creator = ?";
            items.add(item.getCreator());
        }

        return false;
    }
}
