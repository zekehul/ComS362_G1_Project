package src;

import java.util.ArrayList;
import java.util.List;

public class ServiceRequest implements ServiceRequestInterface{

	private String srid;
	private List<Sensor> sensors;
	
	public String getSrid() {
		return srid;
	}

	public void setSrid(String srid) {
		this.srid = srid;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

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
}