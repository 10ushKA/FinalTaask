package by.niitzi.bushylo.v3.dao;

import by.niitzi.bushylo.v3.entity.User;
import by.niitzi.bushylo.v3.exception.DAOException;

import java.util.Optional;

public interface AdminDAO {
    Optional<User> findAdmin(String username);

    User createUser(User user) throws DAOException;

    boolean updateAdmin(User user, int userId);
}
