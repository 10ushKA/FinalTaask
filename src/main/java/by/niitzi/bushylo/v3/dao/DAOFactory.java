package by.niitzi.bushylo.v3.dao;

import by.niitzi.bushylo.v3.dao.impl.AdminDAOImpl;
import by.niitzi.bushylo.v3.dao.impl.ClientDAOImpl;
import by.niitzi.bushylo.v3.dao.impl.WardrobeDAOImpl;

public class DAOFactory {
    public static AdminDAO getAdminDAO(){
        return AdminDAOImpl.getInstance();
    }

    public static ClientDAO getClientDAO(){
        return ClientDAOImpl.getInstance();
    }

    public static WardrobeDAO getWardrobeDAO(){
        return WardrobeDAOImpl.getInstance();
    }
}
