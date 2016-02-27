package src;

import java.util.List;

public class TownController implements TownControllerInterface{

	@Override
	public boolean addSensor(String street, int section, int threshold) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSensor(String sid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStrain(String street, int section, int newStrain) {
		// TODO Auto-generated method stub
		return false;
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
		return null;
	}

	@Override
	public List<Sensor> getDeadSensors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createServiceRequest(int[] sid_arr) {
		// TODO Auto-generated method stub
		return false;
	}

}