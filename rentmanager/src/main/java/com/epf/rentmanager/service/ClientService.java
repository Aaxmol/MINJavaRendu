package com.epf.rentmanager.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.dao.ClientDao;

@Service
public class ClientService {

	private ClientDao clientDao;
	//public static ClientService instance;
	private ClientService(ClientDao clientDao){
		this.clientDao = clientDao;
		}
	
	/*private ClientService() {
		this.clientDao = ClientDao.getInstance();
	}
	
	public static ClientService getInstance() {
		if (instance == null) {
			instance = new ClientService();
		}
		
		return instance;
	}*/
	
	
	public long create(Client client) throws ServiceException {
		// TODO: créer un client
		
		try {
			return this.clientDao.create(client);

		} catch (DaoException e) {
			e.printStackTrace();
		}

	return 0;
	}
	
	public long delete(int id) throws ServiceException {
		// TODO: supprimer un client
		
		try {
			return this.clientDao.delete(id);

		} catch (DaoException e) {
			e.printStackTrace();
		}

	return 0;
	}
	
	public long modifie(Client modifieClient) throws ServiceException {
		// TODO: créer un client
		
		try {
			return this.clientDao.modifie(modifieClient);

		} catch (DaoException e) {
			e.printStackTrace();
		}

	return 0;
	}

	public Client findById(int id) throws ServiceException {
		
		try {
			return this.clientDao.findById(id).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Client> findAll() throws ServiceException {
		
		try {
			return this.clientDao.findAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
	public int count() throws SQLException, DaoException {
		return this.clientDao.count();
	}
	
}
