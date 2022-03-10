package com.epf.rentmanager.model;

public class Vehicle {
	private int id;
	private String constructor;
	//private String modele;
	private int numPlace;
	
	public Vehicle() {
		
	}
	
	public Vehicle(int id, String constructor, int numPlace) {
		super();
		this.id = id;
		this.constructor = constructor;
		this.numPlace = numPlace;
	}
	
	
	 @Override
	 public String toString() {
		return "----------------------------------------------------"
				+ "\nid : "+ id
				+ "\nconstructor : " + constructor
				//+ "\nmodele : " + modele
				+ "\nnumPlace : " + numPlace;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConstructor() {
		return constructor;
	}
	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}
	public int getNumPlace() {
		return numPlace;
	}
	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}
	
}
