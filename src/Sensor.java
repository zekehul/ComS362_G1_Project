package src;

public class Sensor implements SensorInterface{
	
	private String sid;
	private String streetName;
	private int section;
	private int value;
	private int threshold;
	private int status;

	@Override
	public int updateStrain(int strainValue) {
		value = strainValue;
		return value;
	}

	@Override
	public int reset() {
		value = 0;
		return value;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}