package com.epf.rentmanager.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.ReservationDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;

@Service
public class RentService {


	private ReservationDao reservationDao;
	//public static ClientService instance;
	private RentService(ReservationDao reservationDao){
		this.reservationDao = reservationDao;
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
	
	
	public long create(Reservation reservation) throws ServiceException {
		// TODO: créer un client
		try {
			return this.reservationDao.create(reservation);

		} catch (DaoException e) {
			e.printStackTrace();
		}

	return 0;
	}
	
	public long delete(int id) throws ServiceException {
		// TODO: supprimer une reservation
		try {
			return this.reservationDao.delete(id);

		} catch (DaoException e) {
			e.printStackTrace();
		}

	return 0;
	}
	
	public List<Reservation> findResaByClientId(int clientId) throws ServiceException {
		try {
			return this.reservationDao.findResaByClientId(clientId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Reservation> findResaByVehicleId(int vehicleId) throws ServiceException {
		try {
			return this.reservationDao.findResaByVehicleId(vehicleId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Reservation findById(int id) throws ServiceException {
		try {
			return this.reservationDao.findById(id).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Reservation> findAll() throws ServiceException {
		try {
			return this.reservationDao.findAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
	public int count() throws SQLException, DaoException {
		return this.reservationDao.count();
	}
	
	public int countResaByClientId(int clientId) throws SQLException, DaoException {
		return this.reservationDao.countResaByClientId(clientId);
	}
	
}
