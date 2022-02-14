package by.niitzi.bushylo.v3.service.impl;


import by.niitzi.bushylo.v3.dao.ClientDAO;
import by.niitzi.bushylo.v3.dao.impl.ClientDAOImpl;
import by.niitzi.bushylo.v3.entity.Client;
import by.niitzi.bushylo.v3.exception.ServiceException;
import by.niitzi.bushylo.v3.service.ClientService;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    private ClientServiceImpl() {
    }

    private static ClientServiceImpl clientService;

    public static ClientServiceImpl getInstance() {
        if (clientService == null) {
            clientService = new ClientServiceImpl();
        }
        return clientService;
    }

    private final ClientDAO clientDao = ClientDAOImpl.getInstance();

    @Override
    public Optional<Client> findClient(String username) throws ServiceException {
        try{
            return clientDao.findClient(username);
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Client DAO provides exception in service : " + e.getMessage());
        }
    }

    @Override
    public Client createClient(Client client) throws ServiceException {

        try {
            Optional<Client> clientOptional = clientDao.findClient(client.getUsername());
            if(clientOptional.isEmpty()){
                return clientDao.createClient(client);
            }
        }catch (Exception e){//here should be DAOException, but ide underline it as an error
            throw new ServiceException("Client DAO provides exception in service : " + e.getMessage());
        }
        return client;
    }

    @Override
    public List<Client> findAllClients() throws ServiceException {
        try{
           return clientDao.findAllClients();
        }catch (Exception e) {
            throw new ServiceException("Client DAO provides exception in service : " + e.getMessage());
        }

    }

    @Override
    public void deleteClient(int clientId) throws ServiceException {
        clientDao.deleteClient(clientId);
    }

    @Override
    public void updateClient(Client client) throws ServiceException {
        clientDao.updateClient(client);
    }
}
