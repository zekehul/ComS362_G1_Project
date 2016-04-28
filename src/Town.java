package src;

import java.util.List;

public class Town implements TownInterface {
	
	private User userSingleton = null;
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
		if(s==null){
			return false;
		}
		s.updateStrain(newStrain);
		return this.getDB().putSensor(s);
	}
	
	@Override
	public boolean resetSensor(String sid) {
		Sensor s = this.getDB().getSensor(sid);
		if(s==null){
			return false;
		}
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
		return this.getDB().getServiceRequest(srid);
	}

	@Override
	public List<ServiceRequest> getAllServiceRequests() {
		return this.getDB().getAllServiceRequests();
	}

	@Override
	public boolean updateServiceRequest(String srid, int stat) {
		ServiceRequest sr = this.getDB().getServiceRequest(srid);
		if(sr==null){
			return false;
		}
		sr.setStatus(stat);
		return this.getDB().putServiceRequest(sr);
	}

	@Override
	public List<Street> getAllStreets() {
		return this.getDB().getAllStreets();
	}

	@Override
	public List<ServiceRequest> getAllOutstandingServiceRequests() {
		return this.getDB().getAllOutstandingServiceRequests();
	}

	@Override
	public List<ServiceRequest> getAllClosedServiceRequests() {
		return this.getDB().getAllClosedServiceRequests();
	}

	@Override
	public boolean addStreet(String stid, String name) {
		Street st = new Street();
		st.setStid(stid);
		st.setName(name);
		return this.getDB().createStreet(st);
	}

	@Override
	public boolean updateStreet(String stid, String newName) {
		Street st = this.getDB().getStreet(stid);
		if(st==null){
			return false;
		}
		st.setName(newName);
		return this.getDB().putStreet(st);
	}

	@Override
	public int deleteStreet(String stid) {
		return this.getDB().deleteStreet(stid);
	}

	@Override
	public boolean addBridge(String bid, String name) {
		Bridge br= new Bridge();
		br.setBid(bid);
		br.setName(name);
		return this.getDB().createBridge(br);
	}

	@Override
	public int deleteBridge(String bid) {
		return this.getDB().deleteBridge(bid);
	}

	@Override
	public boolean updateBridge(String bid, String name) {
		Bridge br = this.getDB().getBridge(bid);
		if(br==null){
			return false;
		}
		br.setName(name);
		return this.getDB().putBridge(br);
	}

	@Override
	public List<Bridge> getAllBridges() {
		return this.getDB().getAllBridges();
	}

	@Override
	public List<Sensor> getSensorsInStreet(String stid) {
		return this.getDB().getAllSensorWithGivenStid(stid);
	}

	@Override
	public List<Sensor> getSensorsInBridge(String bid) {
		return this.getDB().getAllSensorWithGivenStid(bid);
	}

	@Override
	public List<Sensor> getSensorsInServiceRequest(String srid) {
		return this.getDB().getAllSensorWithGivenSrid(srid);
	}

	@Override
	public int logon(String username, String pwd) {
		User u = this.getDB().getUser(username);
		if(u == null){
			return -1;
		}
		else if(u.validate(pwd) == false){
			return 1;
		}
		else{
			return 0;
		}
	}

	@Override
	public boolean setUserSingleton(User u) {
		this.userSingleton = u;
		return true;
	}

	@Override
	public boolean resetUserSingleton() {
		this.userSingleton = null;
		return true;
	}

	@Override
	public int getUserType() {
		return this.userSingleton.getUserType();
	}

	
}
