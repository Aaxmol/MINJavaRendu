package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.configurations.AppConfiguration;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.RentService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/rents/create")
public class CreateRentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	RentService newRentService;
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	ClientService clientService;
	
	@Override
	public void init() throws ServletException {
	super.init();
	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO
	
		
    	try {
			request.setAttribute("vehicles", vehicleService.findAll());
			request.setAttribute("clients", clientService.findAll());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	getServletContext().getRequestDispatcher("/WEB-INF/views/rents/create.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idClient = Integer.parseInt(request.getParameter("client_id"));
		int idVehicle = Integer.parseInt(request.getParameter("vehicle_id"));
		String dateStart = request.getParameter("debut");
		String dateEnd = request.getParameter("fin");	
		LocalDate startDateLocal= LocalDate.parse(dateStart);
		LocalDate endDateLocal= LocalDate.parse(dateEnd);	  		     		
        Reservation addReservation=new Reservation(1,idClient,idVehicle,startDateLocal, endDateLocal);
        
        try {
        	this.newRentService.create(addReservation);
        	
		} catch (ServiceException e) {
		
		}
        
		this.doGet(request,response);

}
}

