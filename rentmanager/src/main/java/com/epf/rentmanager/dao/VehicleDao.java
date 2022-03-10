package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository
public class VehicleDao {
	
	//private static VehicleDao instance = null;
	private VehicleDao() {}
	
	/*public static VehicleDao getInstance() {
		if(instance == null) {
			instance = new VehicleDao();
		}
		return instance;
	}*/
	
	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, nb_places) VALUES(?, ?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle;";
	private static final String COUNT_VEHICLES_QUERY = "SELECT COUNT (*) FROM Vehicle;";
	private static final String MODIFIE_VEHICLE_QUERY = "UPDATE Vehicle SET constructeur=?, nb_places=? WHERE id=?;";
	
	
	public long create(Vehicle vehicle) throws DaoException {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_VEHICLE_QUERY);

			pstmt.setString(1, vehicle.getConstructor());
			pstmt.setInt(2, vehicle.getNumPlace());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	
	public long delete(int id) throws DaoException {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_VEHICLE_QUERY);

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public long modifie(Vehicle vehicle) throws DaoException {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(MODIFIE_VEHICLE_QUERY);

			pstmt.setString(1, vehicle.getConstructor());
			pstmt.setInt(2, vehicle.getNumPlace());
			pstmt.setInt(3, vehicle.getId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	
	public Optional<Vehicle> findById(int id) throws DaoException {

		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLE_QUERY);
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String vehicleConstructor = rs.getString("constructeur");
			int vehicleNumPlace = rs.getInt("nb_places");
			Vehicle vehicle = new Vehicle(id, vehicleConstructor, vehicleNumPlace);
			
			return Optional.of(vehicle);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}

	
	public List<Vehicle> findAll() throws DaoException {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		try {
			Connection conn= ConnectionManager.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(FIND_VEHICLES_QUERY);
			
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
			int id=rs.getInt("id");
			String vehicleConstructor=rs.getString("constructeur");
			int vehicleNumPlace=rs.getInt("nb_places");
			Vehicle vehicle = new Vehicle(id, vehicleConstructor, vehicleNumPlace);
			vehicles.add(vehicle);
			}
			
			return vehicles;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public int count() throws SQLException {
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(COUNT_VEHICLES_QUERY);

		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int compte = rs.getInt(1);
		return compte;
			
	}
	

}
