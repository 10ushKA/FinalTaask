package by.niitzi.bushylo.v3.service;

import by.niitzi.bushylo.v3.entity.User;

import by.niitzi.bushylo.v3.exception.DAOException;
import by.niitzi.bushylo.v3.exception.ServiceException;
import java.util.Optional;

public interface AdminService {
    Optional<User> findAdmin(String username) throws ServiceException, DAOException;

    User createUser(User user) throws ServiceException;

    boolean updateAdmin(User user) throws ServiceException;
}
