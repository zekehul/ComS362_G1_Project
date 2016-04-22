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

	@Override
	public ServiceRequest searchServiceRequest(String srid) {
		return this.getTownInstance().searchServiceRequest(srid);
	}

	@Override
	public List<ServiceRequest> getAllServiceRequests() {
		// TODO Auto-generated method stub
		return this.getTownInstance().getAllServiceRequests();
	}

	@Override
	public boolean updateServiceRequest(String srid, int stat) {
		// TODO Auto-generated method stub
		return this.getTownInstance().updateServiceRequest(srid, stat);
	}

	@Override
	public List<Street> getAllStreets() {
		// TODO Auto-generated method stub
		return this.getTownInstance().getAllStreets();
	}

	@Override
	public List<ServiceRequest> getAllOutstandingServiceRequests() {
		// TODO Auto-generated method stub
		return this.getTownInstance().getAllOutstandingServiceRequests();
	}

	@Override
	public List<ServiceRequest> getAllClosedServiceRequests() {
		// TODO Auto-generated method stub
		return this.getTownInstance().getAllClosedServiceRequests();
	}

	@Override
	public boolean addStreet(String stid, String name) {
		// TODO Auto-generated method stub
		return this.getTownInstance().addStreet(stid,name);
	}

	@Override
	public boolean updateStreet(String name, String newName) {
		// TODO Auto-generated method stub
		return this.getTownInstance().updateStreet(name,newName);
	}

	@Override
	public int deleteStreet(String name) {
		// TODO Auto-generated method stub
		return this.getTownInstance().deleteStreet(name);
	}

}
