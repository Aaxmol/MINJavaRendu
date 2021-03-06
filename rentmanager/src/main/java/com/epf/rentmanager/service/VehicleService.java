package com.epf.rentmanager.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.VehicleDao;

@Service
public class VehicleService {

	private VehicleDao vehicleDao;
	//public static VehicleService instance;
	
	private VehicleService(VehicleDao vehicleDao){
		this.vehicleDao = vehicleDao;
		}
	
	/*private VehicleService() {
		this.vehicleDao = VehicleDao.getInstance();
	}
	
	public static VehicleService getInstance() {
		if (instance == null) {
			instance = new VehicleService();
		}
		
		return instance;
	}*/
	
	
	public long create(Vehicle vehicle) throws ServiceException {
		// TODO: créer un véhicule
		try {
			return this.vehicleDao.create(vehicle);

		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public long delete(int id) throws ServiceException {
		// TODO: supprimer un véhicule
		try {
			return this.vehicleDao.delete(id);

		} catch (DaoException e) {
			e.printStackTrace();
		}

	return 0;
	}
	
	public long modifie(Vehicle modifieVehicle) throws ServiceException {
		// TODO: créer un vehicule
		try {
			return this.vehicleDao.modifie(modifieVehicle);

		} catch (DaoException e) {
			e.printStackTrace();
		}

	return 0;
	}

	public Vehicle findById(int id) throws ServiceException {
		try {
			return this.vehicleDao.findById(id).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Vehicle> findAll() throws ServiceException {
		try {
			return this.vehicleDao.findAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int count() throws SQLException, DaoException {
		return this.vehicleDao.count();
	}
	
}
