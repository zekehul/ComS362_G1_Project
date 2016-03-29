package src;

import java.util.List;

public class TownController implements TownControllerInterface{

	private Town town = null;
	
	@Override
	public boolean addSensor(String sid, String street, int section, int threshold) {
		return this.getTownInstance().addSensor(sid, street, section, threshold);
	}

	@Override
	public int deleteSensor(String sid) {
		return this.getTownInstance().deleteSensor(sid);
	}

	@Override
	public boolean updateStrain(String sid, int newStrain) {
		return this.getTownInstance().updateStrain(sid, newStrain);
	}

	@Override
	public boolean resetSensor(String sid) {
		return this.getTownInstance().resetSensor(sid);
	}

	@Override
	public List<Sensor> getAllSensors() {
		return this.getTownInstance().getAllSensors();
	}

	@Override
	public Sensor searchForSensor(String street, int section) {
		return this.getTownInstance().searchForSensor(street, section);
	}

	@Override
	public List<Sensor> getCriticalSensors() {
		return this.getTownInstance().getCriticalSensors();
	}

	@Override
	public List<Sensor> getDeadSensors() {
		return this.getTownInstance().getDeadSensors();
	}

	@Override
	public boolean createServiceRequest(String srid, String[] sid_arr) {
		return this.getTownInstance().createServiceRequest(srid, sid_arr);
	}
	
	@Override
	public Sensor searchForSensor(String sid) {
		return this.getTownInstance().searchForSensor(sid);
	}
	
	private Town getTownInstance(){
		if(town == null){
			return new Town();
		}
		else{
			return town;
		}
	}

}
