package src;

import java.util.ArrayList;
import java.util.List;

public class ServiceRequest implements ServiceRequestInterface{

	// service request id number
	private String srid;
	
	// list of sensors in the service request
	private List<Sensor> sensors;
	
	//0 for Outstanding
	//1 for Closed
	private int status;
	
	// gets the service request's id number
	public String getSrid() {
		return srid;
	}

	// sets the service request's id number
	public void setSrid(String srid) {
		this.srid = srid;
	}

	// gets the list of sensors in the service request
	public List<Sensor> getSensors() {
		return sensors;
	}

	// sets the list of sensors in the service request
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	// adds a sensor s to the list of sensors in the service
	// request. If the list has not been initialized, it is
	// initialized here
	@Override
	public boolean addSensorToRequest(Sensor s) {
		if(this.sensors == null){
			this.sensors = new ArrayList<Sensor>();
			return sensors.add(s);
		}
		else{
			return sensors.add(s);
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
