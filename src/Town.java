package src;

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
		return false;
	}
	@Override
	public List<Sensor> getAllSensors() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Sensor searchForSensor(String street, int section) {
		// TODO Auto-generated method stub
		return null;
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
	public boolean createServiceRequest(int[] sid_arr) {
		// TODO Auto-generated method stub
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
