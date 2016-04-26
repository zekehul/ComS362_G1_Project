package src;

import java.util.List;

public class TownController implements TownControllerInterface{

	private Town town = null;
	
	// function to add a sensor to the database
	@Override	
	public boolean addSensor(String sid, String street, int section, int threshold) {
		return this.getTownInstance().addSensor(sid, street, section, threshold);
	}

	// function to delete the sensor from the database
	@Override
	public int deleteSensor(String sid) {
		return this.getTownInstance().deleteSensor(sid);
	}

	// function to update the strain value stored in the sensor identified by `sid`
	@Override
	public boolean updateStrain(String sid, int newStrain) {
		return this.getTownInstance().updateStrain(sid, newStrain);
	}

	// function to reset the strain values in the sensor
	@Override
	public boolean resetSensor(String sid) {
		return this.getTownInstance().resetSensor(sid);
	}

	// function to get all the sensors in the database
	@Override
	public List<Sensor> getAllSensors() {
		return this.getTownInstance().getAllSensors();
	}

	// function to search for a specific sensor, identified by a street name
	// and section number
	@Override
	public Sensor searchForSensor(String street, int section) {
		return this.getTownInstance().searchForSensor(street, section);
	}

	// function to get the sensors that are in critical condition
	@Override
	public List<Sensor> getCriticalSensors() {
		return this.getTownInstance().getCriticalSensors();
	}

	// function to get the sensors that are considered dead
	@Override
	public List<Sensor> getDeadSensors() {
		return this.getTownInstance().getDeadSensors();
	}

	// function to create a service request to repair section(s) of a street
	// or bridge
	@Override
	public boolean createServiceRequest(String srid, String[] sid_arr) {
		return this.getTownInstance().createServiceRequest(srid, sid_arr);
	}
	
	// function to search for a specific sensor, identified by the sensor
	// id number
	@Override
	public Sensor searchForSensor(String sid) {
		return this.getTownInstance().searchForSensor(sid);
	}
	
	// function to create a singleton of `town`
	private Town getTownInstance(){
		if(town == null){
			return new Town();
		}
		else{
			return town;
		}
	}

	// function to search for a service request given a service request ID
	@Override
	public ServiceRequest searchServiceRequest(String srid) {
		return this.getTownInstance().searchServiceRequest(srid);
	}

	// function to list all service requests
	@Override
	public List<ServiceRequest> getAllServiceRequests() {
		return this.getTownInstance().getAllServiceRequests();
	}

	// function to update the status of the service request with ID of `srid`
	@Override
	public boolean updateServiceRequest(String srid, int stat) {
		return this.getTownInstance().updateServiceRequest(srid, stat);
	}

	// function to list all streets in town
	@Override
	public List<Street> getAllStreets() {
		return this.getTownInstance().getAllStreets();
	}

	// function to list all service requests that have not been closed
	@Override
	public List<ServiceRequest> getAllOutstandingServiceRequests() {
		return this.getTownInstance().getAllOutstandingServiceRequests();
	}

	// function to list all service requests that have been closed
	@Override
	public List<ServiceRequest> getAllClosedServiceRequests() {
		return this.getTownInstance().getAllClosedServiceRequests();
	}

	// function to add a street to the database
	@Override
	public boolean addStreet(String stid, String name) {
		return this.getTownInstance().addStreet(stid,name);
	}

	// function to update the name of the street
	@Override
	public boolean updateStreet(String stid, String newName) {
		return this.getTownInstance().updateStreet(stid,newName);
	}

	// function to remove the street from the database
	@Override
	public int deleteStreet(String stid) {
		return this.getTownInstance().deleteStreet(stid);
	}

	@Override
	public boolean addBridge(String bid, String name) {
		return this.getTownInstance().addBridge(bid, name);
	}

	@Override
	public int deleteBridge(String bid) {
		return this.getTownInstance().deleteBridge(bid);
	}

	@Override
	public boolean updateBridge(String bid, String name) {
		return this.getTownInstance().updateBridge(bid, name);
	}

	@Override
	public List<Bridge> getAllBridges() {
		return this.getTownInstance().getAllBridges();
	}

	@Override
	public List<Sensor> getSensorsInStreet(String stid) {
		return this.getTownInstance().getSensorsInStreet(stid);
	}

	@Override
	public List<Sensor> getSensorsInBridge(String bid) {
		return this.getTownInstance().getSensorsInBridge(bid);
	}

	@Override
	public List<Sensor> getSensorsInServiceRequest(String srid) {
		return this.getTownInstance().getSensorsInServiceRequest(srid);
	}

	@Override
	public int logon(String username, String pwd) {
		return this.getTownInstance().logon(username, pwd);
	}

	@Override
	public boolean logoff() {
		return this.getTownInstance().resetUserSingleton();
	}

}
