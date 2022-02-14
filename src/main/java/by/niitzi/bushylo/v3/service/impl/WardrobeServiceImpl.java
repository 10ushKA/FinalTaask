package by.niitzi.bushylo.v3.service.impl;

import by.niitzi.bushylo.v3.dao.ClientDAO;
import by.niitzi.bushylo.v3.dao.WardrobeDAO;
import by.niitzi.bushylo.v3.dao.impl.ClientDAOImpl;
import by.niitzi.bushylo.v3.dao.impl.WardrobeDAOImpl;
import by.niitzi.bushylo.v3.entity.Item;
import by.niitzi.bushylo.v3.entity.Wardrobe;
import by.niitzi.bushylo.v3.service.WardrobeService;

import javax.xml.rpc.ServiceException;
import java.sql.SQLException;
import java.util.List;

public class WardrobeServiceImpl implements WardrobeService {

    private WardrobeServiceImpl(){

    }

    private static WardrobeServiceImpl wardrobeServiceImpl;

    public static WardrobeServiceImpl getInstance(){
        if(wardrobeServiceImpl == null){
            wardrobeServiceImpl = new WardrobeServiceImpl();
        }
        return wardrobeServiceImpl;
    }

    private final ClientDAO clientDao = ClientDAOImpl.getInstance();
    private final WardrobeDAO wardrobeDAO = WardrobeDAOImpl.getInstance();

    @Override
    public Wardrobe createWardrobe(Wardrobe wardrobe, int clientId) throws ServiceException {
        try {
            return wardrobeDAO.createWardrobe(wardrobe,clientId);
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Wardrobe DAO provides exception in service : " + e.getMessage());
        }
    }

    @Override
    public Wardrobe findWardrobe(int clientId) throws ServiceException {
        try {
            return wardrobeDAO.findWardrobe(clientId);
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Wardrobe DAO provides exception in service : " + e.getMessage());
        }
    }

    @Override
    public List<Wardrobe> findAll() throws ServiceException {
        try {
            return wardrobeDAO.findAll();
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Wardrobe DAO provides exception in service : " + e.getMessage());
        }
    }

    @Override
    public boolean deleteWardrobe(int wardrobeId) throws SQLException, ServiceException {
        try {
            return wardrobeDAO.deleteWardrobe(wardrobeId);
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Wardrobe DAO provides exception in service : " + e.getMessage());
        }
    }

    @Override
    public boolean updateWardrobe(Wardrobe wardrobe) throws ServiceException {
        try {
            return wardrobeDAO.updateWardrobe(wardrobe);
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Wardrobe DAO provides exception in service : " + e.getMessage());
        }
    }

    @Override
    public Item createItem(Item item, int wardrobeId, int typeId) throws ServiceException {
        try {
            return wardrobeDAO.createItem(item,wardrobeId,typeId);
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Wardrobe DAO provides exception in service : " + e.getMessage());
        }
    }

    @Override
    public boolean deleteItem(int itemId) throws SQLException, ServiceException {
        try {
            return wardrobeDAO.deleteItem(itemId);
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Wardrobe DAO provides exception in service : " + e.getMessage());
        }
    }

    @Override
    public boolean updateItem(Item item) throws ServiceException {
        try {
            return wardrobeDAO.updateItem(item);
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Wardrobe DAO provides exception in service : " + e.getMessage());
        }
    }
}
