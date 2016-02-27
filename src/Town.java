package src;

import java.util.List;

public class Town implements TownInterface {
	
	private DatabaseSupport db = null;
	
	@Override
	public boolean addSensor(String street, int section, int threshold) {
		Sensor s = new Sensor();
		s.setStreetName(street);
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
		// TODO Auto-generated method stub
		Sensor s = this.getDB().getSensor(sid);
		s.reset();
		return this.getDB().putSensor(s);
	}
	@Override
	public List<Sensor> getAllSensors() {
		// TODO Auto-generated method stub
		return this.getDB().getAllSensors();
	}
	@Override
	public Sensor searchForSensor(String street, int section) {
		// TODO Auto-generated method stub
		return this.getDB().getSensor(street, section);
	}
	@Override
	public List<Sensor> getCriticalSensors() {
		// TODO Auto-generated method stub
		return this.getDB().getCriticalSensors();
	}
	@Override
	public List<Sensor> getDeadSensors() {
		// TODO Auto-generated method stub
		return this.getDB().getDeadSensors();
	}
	@Override
	public boolean createServiceRequest(String[] sid_arr) {
		// TODO Auto-generated method stub
		// create serviceRequest
		// for each element in `sid_arr`
		// grab the `Sensor` with the ID `sid_arr[i]`
		// add the sensor to the serviceRequest
		// once all IDs are added, add the serviceRequest to the database
		ServiceRequest sr = new ServiceRequest();
		for(String s : sid_arr)
		return false;
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
