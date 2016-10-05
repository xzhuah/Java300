package com.hkust.main;

import java.io.FileNotFoundException;

import com.hkust.bean.Flight;
import com.hkust.dao.FlightDAOImpl;
import com.hkust.util.DataGetter;
import com.hkust.util.SimpleTXTDBMS;

public class Collector {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		/*DataGetter data=new DataGetter("D:/BTS _ Airline On-Time Statistics.html");
		Flight f[]=data.getData();
		FlightDAOImpl dao=new FlightDAOImpl();
		for(int i=0;i<f.length;i++){
			dao.addFlight(f[i]);
		}*/
		int a[]={0};
		SimpleTXTDBMS<Flight> db=new SimpleTXTDBMS("D:/Flight.txt",a,"com.hkust.bean.Flight");
		Flight f=db.getByPrimeKey("AA");
		System.out.println(f.getADeptTime());
		System.out.println(f.getDate());
		Flight ff=new Flight();
		ff.setCarrierCode("AA");
		db.addObject(ff);
		

	}

}
