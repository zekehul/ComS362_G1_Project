package src;

import java.util.List;

public class Street implements StreetInterface {

	private String stid;
	private String name;
	private List<Sensor> sensors;
	
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Sensor> getSensors() {
		return sensors;
	}
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	
	@Override
	public boolean updateStreet(String newName) {
		this.name = newName;
		return true;
	}
}
