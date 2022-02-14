package by.niitzi.bushylo.v3.service;

import by.niitzi.bushylo.v3.entity.Item;
import by.niitzi.bushylo.v3.entity.Wardrobe;

import javax.xml.rpc.ServiceException;
import java.sql.SQLException;
import java.util.List;

public interface WardrobeService {
    Wardrobe createWardrobe(Wardrobe wardrobe, int clientId) throws ServiceException;

    Wardrobe findWardrobe(int clientId) throws ServiceException;

    List<Wardrobe> findAll() throws ServiceException;

    boolean deleteWardrobe(int wardrobeId) throws SQLException, ServiceException;

    boolean updateWardrobe(Wardrobe wardrobe) throws ServiceException;

    Item createItem(Item item, int wardrobeId, int typeId) throws ServiceException;

    boolean deleteItem(int itemId) throws SQLException, ServiceException;

    boolean updateItem(Item item) throws ServiceException;
}
