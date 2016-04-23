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
	public boolean putStreet(Street st);
	
}
