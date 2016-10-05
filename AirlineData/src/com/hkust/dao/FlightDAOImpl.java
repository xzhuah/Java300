package com.hkust.dao;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.hkust.bean.Flight;

public class FlightDAOImpl {

	/**
	 * @param args
	 */
	private BufferedOutputStream bfo;
	public FlightDAOImpl() throws FileNotFoundException{
		bfo=new BufferedOutputStream(new FileOutputStream("D:/Flight.txt",true));
		
	}
	public void addFlight(Flight f) throws IOException{
		bfo.write((f.getCarrierCode()+"\t").getBytes());
		bfo.write((f.getDate()+"\t").getBytes());
		bfo.write((f.getFlightNumber()+"\t").getBytes());
		
		bfo.write((f.getTailNumber()+"\t").getBytes());
		bfo.write((f.getDestAirport()+"\t").getBytes());
		bfo.write((f.getSDeptTime()+"\t").getBytes());
		bfo.write((f.getADeptTime()+"\t").getBytes());
		
		bfo.write((f.getSElapsedTime()+"\t").getBytes());
		bfo.write((f.getAElapsedTime()+"\t").getBytes());
		bfo.write((f.getDeptDelay()+"\t").getBytes());
		bfo.write((f.getWheelsOffTime()+"\t").getBytes());
		bfo.write((f.getTaxiOutTime()+"\t").getBytes());
		
		bfo.write((f.getDelayCarrier()+"\t").getBytes());
		bfo.write((f.getDelayWeather()+"\t").getBytes());
		bfo.write((f.getDNAS()+"\t").getBytes());
		bfo.write((f.getDS()+"\t").getBytes());
		bfo.write((f.getDLAA()+"\n").getBytes());
	}
	/*public Flight[] getFlight(String s){
		
	}*/
}
