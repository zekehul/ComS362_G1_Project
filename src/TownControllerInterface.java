package src;

import java.util.List;

public interface TownControllerInterface {

	public boolean addSensor(String sid, String street, int section, int threshold);
	public int deleteSensor(String sid);
	public boolean updateStrain(String sid, int newStrain);
	public boolean resetSensor(String sid);
	public List<Sensor> getAllSensors();
	public Sensor searchForSensor(String street, int section);
	public Sensor searchForSensor(String sid);
	public List<Sensor> getCriticalSensors();
	public List<Sensor> getDeadSensors();
	public boolean createServiceRequest(String srid, String[] sid_arr);
	public ServiceRequest searchServiceRequest(String srid);
	public List<ServiceRequest> getAllServiceRequests();
	public boolean updateServiceRequest(String srid, int stat);
	public List<Street> getAllStreets();
	public List<ServiceRequest> getAllOutstandingServiceRequests();
	public List<ServiceRequest>getAllClosedServiceRequests();
	public boolean addStreet(String stid, String name);
	public boolean updateStreet(String name, String newName);
	public int deleteStreet(String name);

}
