package by.niitzi.bushylo.v3.service;

import by.niitzi.bushylo.v3.entity.Client;
import by.niitzi.bushylo.v3.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Optional<Client> findClient(String userName) throws ServiceException;
    Optional<Client> findClientToLogin(String username) throws ServiceException;

    Client createClient(Client client) throws ServiceException;

    List<Client> findAllClients() throws ServiceException;

    void deleteClient(int clientId) throws ServiceException;

    void updateClient(Client client) throws ServiceException;
}
