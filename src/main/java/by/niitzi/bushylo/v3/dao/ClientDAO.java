package by.niitzi.bushylo.v3.dao;

import by.niitzi.bushylo.v3.entity.Client;
import by.niitzi.bushylo.v3.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface ClientDAO {
    Optional<Client> findClient(String userName);

    Optional<Client> findClientToLogin(String username);

    Client createClient(Client client) throws DAOException;

    List<Client> findAllClients();

    void deleteClient(int clientId);

    void updateClient(Client client);
}
