package com.hotel.service.exceptions;

public class ResourceNotFoundException extends  RuntimeException{

	private static final long serialVersionUID = 2998271040410814978L;

	public ResourceNotFoundException(){
        super("Hotel Details not found on the server !!");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
