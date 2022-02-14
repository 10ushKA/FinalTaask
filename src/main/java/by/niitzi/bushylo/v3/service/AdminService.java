package by.niitzi.bushylo.v3.service;

import by.niitzi.bushylo.v3.entity.User;

import javax.xml.rpc.ServiceException;
import java.util.Optional;

public interface AdminService {
    Optional<User> findAdmin(String username) throws ServiceException;

    User createUser(User user) throws ServiceException;

    boolean updateAdmin(User user) throws ServiceException;
}
