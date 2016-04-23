package src;

import java.util.ArrayList;
import java.util.List;

public class ServiceRequest implements ServiceRequestInterface{

	// service request id number
	private String srid;
	
	//0 for Outstanding
	//1 for Closed
	private int status;
	
	private List<Sensor> sensors;
	
	// gets the service request's id number
	public String getSrid() {
		return srid;
	}

	// sets the service request's id number
	public void setSrid(String srid) {
		this.srid = srid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
}
