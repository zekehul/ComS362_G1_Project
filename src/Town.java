package src;

import java.util.List;

public class Town implements TownInterface {
	
	private DatabaseSupport db = null;
	
	@Override
	public boolean addSensor(String sid, String street, int section, int threshold) {
		Sensor s = new Sensor();
		s.setSid(sid);
		s.setStid(street);
		s.setSection(section);
		s.setThreshold(threshold);
		s.setValue(0);
		return this.getDB().createSensor(s);
	}
	
	@Override
	public int deleteSensor(String sid) {
		return this.getDB().deleteSensor(sid);
	}
	
	@Override
	public boolean updateStrain(String sid, int newStrain) {
		Sensor s = this.getDB().getSensor(sid);
		s.updateStrain(newStrain);
		return this.getDB().putSensor(s);
	}
	
	@Override
	public boolean resetSensor(String sid) {
		Sensor s = this.getDB().getSensor(sid);
		s.reset();
		return this.getDB().putSensor(s);
	}
	
	@Override
	public List<Sensor> getAllSensors() {
		return this.getDB().getAllSensors();
	}
	
	@Override
	public Sensor searchForSensor(String street, int section) {
		return this.getDB().getSensor(street, section);
	}
	
	@Override
	public List<Sensor> getCriticalSensors() {
		return this.getDB().getCriticalSensors();
	}
	
	@Override
	public List<Sensor> getDeadSensors() {
		return this.getDB().getDeadSensors();
	}

	@Override
	public Sensor searchForSensor(String sid) {
		return this.getDB().getSensor(sid);
	}
	
	@Override
	public boolean createServiceRequest(String srid, String[] sid_arr) {
		//TODO
		// create serviceRequest
		// for each element in `sid_arr`
		// grab the `Sensor` with the ID `sid_arr[i]`
		// add the service request ID to the sensor, put Sensor back in DB
		// once all Sensors are updated, add the serviceRequest to the database
		ServiceRequest sr = new ServiceRequest();
		sr.setSrid(srid);
		sr.setStatus(0);
		for(String s : sid_arr){
			Sensor sen = this.getDB().getSensor(s);
			sen.setSrid(srid);
			this.getDB().putSensor(sen);
		}
		return this.getDB().addServiceRequest(sr);
	}
	
	private DatabaseSupport getDB(){
		if(db == null){
			return new DatabaseSupport();
		}
		else{
			return db;
		}
	}

	@Override
	public ServiceRequest searchServiceRequest(String srid) {
		// TODO Auto-generated method stub
		return this.getDB().getServiceRequest(srid);
	}

	@Override
	public List<ServiceRequest> getAllServiceRequests() {
		// TODO Auto-generated method stub
		return this.getDB().getAllServiceRequests();
	}

	@Override
	public boolean updateServiceRequest(String srid, int stat) {
		// TODO Auto-generated method stub
		ServiceRequest sr = this.getDB().getServiceRequest(srid);
		sr.setStatus(stat);
		return this.getDB().putServiceRequest(sr);
	}

	@Override
	public List<Street> getAllStreets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceRequest> getAllOutstandingServiceRequests() {
		// TODO Auto-generated method stub
		return this.getDB().getAllOutstandingServiceRequests();
	}

	@Override
	public List<ServiceRequest> getAllClosedServiceRequests() {
		// TODO Auto-generated method stub
		return this.getDB().getAllClosedServiceRequests();
	}

	@Override
	public boolean addStreet(String stid, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStreet(String name, String newName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteStreet(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
