package src;

import java.util.List;

public class ServiceRequest implements ServiceRequestInterface{

	private List<Sensor> sensors;
	
	@Override
	public boolean addSensorToRequest(Sensor s) {
		return sensors.add(s);
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

}