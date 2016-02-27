package src;

import java.util.List;

public class DatabaseSupport implements DatabaseSupportInterface{

	@Override
	public boolean createSensor(Sensor s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sensor getSensor(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteSensor(String sid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean putSensor(Sensor s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Sensor> getAllSensors() {
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
	public boolean addServiceRequest(ServiceRequest sr) {
		// TODO Auto-generated method stub
		return false;
	}
	

}