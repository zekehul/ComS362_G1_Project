package src;

import java.util.List;

public class TownController implements TownControllerInterface{

	private Town town = null;
	@Override
	public boolean addSensor(String street, int section, int threshold) {
		return this.getTownInstance().addSensor(street, section, threshold);
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
		// TODO Auto-generated method stub
		return this.getTownInstance().resetSensor(sid);
	}

	@Override
	public List<Sensor> getAllSensors() {
		// TODO Auto-generated method stub
		return this.getTownInstance().getAllSensors();
	}

	@Override
	public Sensor searchForSensor(String street, int section) {
		// TODO Auto-generated method stub
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
	public boolean createServiceRequest(int[] sid_arr) {
		return this.getTownInstance().createServiceRequest(sid_arr);
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
