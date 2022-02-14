package by.niitzi.bushylo.v3.dao;

import by.niitzi.bushylo.v3.entity.Item;
import by.niitzi.bushylo.v3.entity.Wardrobe;

import java.sql.SQLException;
import java.util.List;

public interface WardrobeDAO {

    Wardrobe createWardrobe(Wardrobe wardrobe, int clientId);

    Wardrobe findWardrobe(int clientId);

    List<Wardrobe> findAll();

    boolean deleteWardrobe(int wardrobeId) throws SQLException;

    boolean updateWardrobe(Wardrobe wardrobe);

    Item createItem(Item item, int wardrobeId, int typeId);

    boolean deleteItem(int itemId) throws SQLException;

    boolean updateItem(Item item);

}
