package by.niitzi.bushylo.v3.service.impl;

import by.niitzi.bushylo.v3.dao.AdminDAO;
import by.niitzi.bushylo.v3.dao.impl.AdminDAOImpl;
import by.niitzi.bushylo.v3.entity.User;
import by.niitzi.bushylo.v3.service.AdminService;

import javax.xml.rpc.ServiceException;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    private AdminServiceImpl() {
    }

    private static AdminServiceImpl adminService;

    public static AdminServiceImpl getInstance() {
        if (adminService == null) {
            adminService = new AdminServiceImpl();
        }
        return adminService;
    }

    private final AdminDAO adminDAO = AdminDAOImpl.getInstance();


        @Override
    public Optional<User> findAdmin(String username) throws ServiceException {
            try{
                return adminDAO.findAdmin(username);
            }catch (Exception e){//here should be DAOException, but ide underline it as an error
                throw new ServiceException("Admin DAO provides exception in service : " + e.getMessage());
            }
    }

    @Override
    public User createUser(User user) throws ServiceException {
        try {
            return adminDAO.createUser(user);
        } catch (Exception e) {
            throw new ServiceException("Admin DAO, while creating user, provides exception in service : " + e.getMessage());
        }
    }

    @Override
    public boolean updateAdmin(User user) throws ServiceException {
        try{
            return adminDAO.updateAdmin(user, user.getId());//ИЛИ ЗДЕСЬ НЕ ЮЗЕР А АДМИН или должен быть метод для апдейта юзера
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Admin DAO provides exception in service : " + e.getMessage());
        }
    }
}
