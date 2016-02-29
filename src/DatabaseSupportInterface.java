package src;

import java.util.List;

public interface DatabaseSupportInterface {

	public boolean createSensor(Sensor s);
	public Sensor getSensor(String sid);
	public Sensor getSensor(String street, int section);
	public int deleteSensor(String sid);
	public boolean putSensor(Sensor s);
	public List<Sensor> getAllSensors();
	public List<Sensor> getCriticalSensors();
	public List<Sensor> getDeadSensors();
	public boolean addServiceRequest(ServiceRequest sr);
	
}
