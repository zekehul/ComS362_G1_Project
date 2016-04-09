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
		// create serviceRequest
		// for each element in `sid_arr`
		// grab the `Sensor` with the ID `sid_arr[i]`
		// add the sensor to the serviceRequest
		// once all IDs are added, add the serviceRequest to the database
		ServiceRequest sr = new ServiceRequest();
		sr.setSrid(srid);
		for(String s : sid_arr){
			sr.addSensorToRequest(this.getDB().getSensor(s));
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

	
}
