package src;

import java.util.List;

public interface TownControllerInterface {

	public boolean addSensor(String street, int section, int threshold);
	public boolean deleteSensor(String sid);
	public boolean updateStrain(String street, int section, int newStrain);
	public boolean resetSensor(String sid);
	public List<Sensor> getAllSensors();
	public Sensor searchForSensor(String street, int section);
	public List<Sensor> getCriticalSensors();
	public List<Sensor> getDeadSensors();
	public boolean createServiceRequest(int[] sid_arr);
	
}
