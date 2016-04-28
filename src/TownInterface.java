package src;

import java.util.List;

public interface TownInterface {

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
	public boolean updateStreet(String stid, String newName);
	public int deleteStreet(String stid);
	
	public boolean addBridge(String bid, String name);
	public int deleteBridge(String bid);
	public boolean updateBridge(String bid, String name);
	public List<Bridge> getAllBridges();
	public List<Sensor> getSensorsInStreet(String stid);
	public List<Sensor> getSensorsInBridge(String bid);
	public List<Sensor> getSensorsInServiceRequest(String srid);
	
	public int logon(String username, String pwd);
	public boolean setUserSingleton(User u);
	public boolean resetUserSingleton();
	public int getUserType();
}
