package src;

import java.util.List;

public interface TownInterface {

	public boolean addSensor(String street, int section, int threshold);
	public int deleteSensor(String sid);
	public boolean updateStrain(String sid, int newStrain);
	public boolean resetSensor(String sid);
	public List<Sensor> getAllSensors();
	public Sensor searchForSensor(String street, int section);
	public List<Sensor> getCriticalSensors();
	public List<Sensor> getDeadSensors();
	public boolean createServiceRequest(int[] sid_arr);
}
