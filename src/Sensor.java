package src;

public class Sensor implements SensorInterface{
	
	private String sid;
	private String stid;
	private int section;
	private int value;
	private int threshold;
	private int status;
	private String srid;
	@Override
	public int updateStrain(int strainValue) {
		value = strainValue;
		return value;
	}

	//Resets the value of this Sensor to 0
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

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public String getSrid() {
		return srid;
	}

	public void setSrid(String srid) {
		this.srid = srid;
	}

}