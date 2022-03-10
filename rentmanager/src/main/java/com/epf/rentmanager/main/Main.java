package com.epf.rentmanager.main;

import java.io.PrintStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.rentmanager.configurations.AppConfiguration;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.RentService;
import com.epf.rentmanager.service.VehicleService;

public class Main {
	public static void main(String[] args) {
		
		
try {
			
			ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
			ClientService clientService = context.getBean(ClientService.class);
			VehicleService vehicleService = context.getBean(VehicleService.class);
			RentService reservationService = context.getBean(RentService.class);
			
					
		//System.out.println(ClientService.getInstance().findById(1));
		//System.out.println(ClientService.getInstance().findAll());
		//System.out.println(VehicleService.getInstance().findById(1));
		//System.out.println(reservationService.findAll());	
		//System.out.println(clientService.count());
		//System.out.println(vehicleService.count());
		//System.out.println(reservationService.count());
		//System.out.println(reservationService.findResaByClientId(1));
		//System.out.println(reservationService.findResaByVehicleId(2));
		//System.out.println(ReservationService.getInstance().findAll());	


		} catch (Exception e) {
		
			
		}
		
		
			//System.out.println(ClientService.getInstance().findAll());
			//System.out.println(VehicleService.getInstance().findAll());
			
		//ApplicationContext context = new
		//	AnnotationConfigApplicationContext(AppConfiguration.class);
		//	ClientService clientService = context.getBean(ClientService.class);
		//	VehicleService vehicleService = context.getBean(VehicleService.class);	
		//	System.out.println(ClientService.count());
		//System.out.println(clientService);
		//System.out.println(vehicleService);
	}

}
