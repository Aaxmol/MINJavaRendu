package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/cars/modifie")
public class ModifieVehicleServlet extends HttpServlet{

	@Autowired
	VehicleService vehicleService;
	
	@Override
	public void init() throws ServletException {
	super.init();
	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO
		String idNull = request.getQueryString();
		String idOk = idNull.substring(3);
		int id = Integer.parseInt(idOk);
		
        try {
        	
        	this.vehicleService.findById(id);
        	
		} catch (ServiceException e) {
		
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/modifie.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idNull = URLDecoder.decode(request.getQueryString(), "UTF-8");
		System.out.println(idNull);

		String idOk = idNull.substring(3);
		System.out.println(idOk);
		
		int id = Integer.parseInt(idOk);
		
		
        String constructor = request.getParameter("constructor");
		String numPlace = request.getParameter("numPlace");
        int numPlaceOK = Integer.parseInt(numPlace);
        Vehicle modifieVehicle=new Vehicle(id,constructor,numPlaceOK);
        
        try {
        	request.setAttribute("modifieClient", this.vehicleService.modifie(modifieVehicle));
        	
		} catch (ServiceException e) {
		
		}
        
		this.doGet(request,response);
	}
}
