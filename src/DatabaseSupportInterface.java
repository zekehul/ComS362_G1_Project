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
	public ServiceRequest getServiceRequest(String srid);
	public boolean putServiceRequest(ServiceRequest sr);
	public List<ServiceRequest> getAllServiceRequests();
	public List<ServiceRequest> getAllOutstandingServiceRequests();
	public List<ServiceRequest> getAllClosedServiceRequests();
	public List<Street> getAllStreets();
	public Street getStreet(String stid);
	public boolean putStreet(Street st);
	public boolean createStreet(Street st);
	public int deleteStreet(String stid);
	public List<Bridge> getAllBridges();
	public Bridge getBridge(String bid);
	public boolean putBridge(Bridge br);
	public boolean createBridge(Bridge br);
	public int deleteBridge(String bid);
	public List<Sensor> getAllSensorWithGivenStid(String stid);
	public User getUser(String username);
	
}
