package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DatabaseSupport implements DatabaseSupportInterface{

	private Connection connection=null;
	
	//If the sensor already exists, update it, otherwise insert a new sensor
	@Override
	public boolean putSensor(Sensor s) {
		if(this.getSensor(s.getStid(), s.getSection()) == null){
			return createSensor(s);
		}
		else{
			return updateSensor(s);
		}
	}

	//Updates a Sensor
	private boolean updateSensor(Sensor s) {
		boolean returnValue = true;
		
		try{
			connection = this.getConnection();
			String qs = "update Sensors set VAL='" + s.getValue() + "', " +
											"THRSH='"+ s.getThreshold() +"', " +
											"SRID='"+ s.getSrid() +"', " +
											"SEN_STS='"+ s.getStatus() +"' " +
											"where SID='" + s.getSid() +"'";
					
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(qs);
			stmt.close();
			connection.close();
		}
		catch(SQLException sqle){
			returnValue = false;
		}
		return returnValue;
	}

	//Returns Sensor object with the given Sensor ID
	@Override
	public Sensor getSensor(String sid) {
		// TODO Auto-generated method stub
		Sensor s = null;
		try{
			connection = this.getConnection();
			if(connection ==null){
				s = null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from Sensors where SID='"+sid+"'");
				if(rs.next()){
					s = new Sensor();
					s.setSid(sid);
					s.setStid(rs.getString("STID"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
					s.setSrid(rs.getString("SRID"));
				}
				else{
					s = null;
				}
				stmt.close();
				connection.close();
			}
		}
		catch(SQLException sqle){
			
		}
		
		return s;
	}

	//Deletes the Sensor with the given ID
	@Override
	public int deleteSensor(String sid) {
		int returnValue = 0;
		if(this.getSensor(sid) == null){
			returnValue = 1;
		}
		else{
			try{
				connection = this.getConnection();
				if(connection ==null){
					returnValue = -1;
				}
				else{
					Statement stmt = connection.createStatement();
					stmt.execute("delete from Sensors where SID='"+sid+"'");
					stmt.close();
					connection.close();
				}
			}
			catch(SQLException sqle){
				returnValue = -1;
			}
		}
		return returnValue;
	}

	//Inserts the given Sensor Object into the table
	@Override
	public boolean createSensor(Sensor s) {
		boolean returnValue = true;
		
		try{
			connection = this.getConnection();
			String qs = "insert into Sensors values ('" + 
								s.getSid() +"', '" +
								s.getStid() +"', " +
								s.getSection() +", " +
								s.getValue() +", " +
								s.getThreshold() +", " +
								s.getStatus() +", " +
								s.getSrid() +")";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(qs);
			stmt.close();
			connection.close();
		}
		catch(SQLException sqle){
			returnValue = false;
		}
		return returnValue;
	}

	//Returns a list of all the Sensors
	@Override
	public List<Sensor> getAllSensors() {
		List<Sensor> list = new ArrayList<Sensor>();
		try{
			connection = this.getConnection();
			if(connection ==null){
				return null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from Sensors");
				while(rs.next()){
					Sensor s= new Sensor();
					s.setSid(rs.getString("SID"));
					s.setStid(rs.getString("STID"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
					s.setSrid(rs.getString("SRID"));
					list.add(s);
				}
				
				stmt.close();
				connection.close();
			}
		}
		catch(SQLException sqle){
			
		}
		
		return list;
	}

	//Returns a list of all Sensors with a critical status
	@Override
	public List<Sensor> getCriticalSensors() {
		List<Sensor> list = new ArrayList<Sensor>();
		try{
			connection = this.getConnection();
			if(connection ==null){
				return null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from Sensors where sen_sts=1");
				while(rs.next()){
					Sensor s= new Sensor();
					s.setSid(rs.getString("SID"));
					s.setStid(rs.getString("STID"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
					s.setSrid(rs.getString("SRID"));
					list.add(s);
				}
				
				stmt.close();
				connection.close();
				}
		}
		catch(SQLException sqle){
			
		}
		
		return list;
	}

	//Returns a list of all Sensors with a dead status
	@Override
	public List<Sensor> getDeadSensors() {
		List<Sensor> list = new ArrayList<Sensor>();
		try{
			connection = this.getConnection();
			if(connection ==null){
				return null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from Sensors where sen_sts=2");
				while(rs.next()){
					Sensor s= new Sensor();
					s.setSid(rs.getString("SID"));
					s.setStid(rs.getString("STID"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
					s.setSrid(rs.getString("SRID"));
					list.add(s);
				}
				
				stmt.close();
				connection.close();
				}
		}
		catch(SQLException sqle){
			
		}
		
		return list;
	}

	//Inserts the given ServiceRequest into the table
	@Override
	public boolean addServiceRequest(ServiceRequest sr) {
		//TODO
		boolean returnValue = true;		
		try{
			connection = this.getConnection();
			String qs = "insert into ServiceRequest (SRID, SR_STS) values ('" + 
			sr.getSrid() +"', '" +							
			sr.getStatus() +"')";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(qs);
			stmt.close();
			
			connection.close();
		}
		catch(SQLException sqle){
			returnValue = false;
		}
		return returnValue;
	}

	//Returns a Sensor with the given location
	@Override
	public Sensor getSensor(String stid, int section) {
		Sensor s = null;
		try{
			connection = this.getConnection();
			if(connection ==null){
				s = null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from Sensors where STID='"+stid+"' and SECT='" +section+"'");
				if(rs.next()){
					s = new Sensor();
					s.setSid(rs.getString("SID"));
					s.setStid(rs.getString("STID"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
					s.setSrid(rs.getString("SRID"));
				}
				else{
					s = null;
				}
				stmt.close();
				connection.close();
			}
		}
		catch(SQLException sqle){
			
		}
		
		return s;
	}
	
	//Gets the Connection Object
	private Connection getConnection() {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			//Database url
			String url = "jdbc:mysql://mysql.cs.iastate.edu/db362grp01";
			connection = DriverManager.getConnection (url, "dbu362grp01", "caGDcwAqaHE");
		}
		catch(ClassNotFoundException cnfe){
			connection = null;
		}
		catch(SQLException sqle){
			System.out.println(sqle);
			connection = null;
		}
		return connection;
	}

	@Override
	public ServiceRequest getServiceRequest(String srid) {
		ServiceRequest sr = null;
		try{
			connection = this.getConnection();		
			if(connection ==null){
				return null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from ServiceRequest where srid="+srid);
				
				if(rs.next()){	
					sr= new ServiceRequest();
					sr.setSrid(rs.getString("SRID"));
					sr.setStatus(rs.getInt("SR_STS"));
					sr.setSensors(getAllSensorWithGivenSrid(srid));
				}
				else{
					sr = null;
				}
				stmt.close();
				connection.close();
				}
		}
		catch(SQLException sqle){
			
		}
		return sr;
	}

	@Override
	public boolean putServiceRequest(ServiceRequest sr) {
		if(this.getServiceRequest(sr.getSrid()) == null){
			return createServiceRequest(sr);
		}
		else{
			return updateServiceRequest(sr);
		}
	}
	public boolean createServiceRequest(ServiceRequest sr) {
		boolean returnValue = true;
		
		try{
			connection = this.getConnection();
			String qs = "insert into ServiceRequest values ('" + 
								sr.getSrid() +"', '" +
								sr.getStatus() +"')";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(qs);
			stmt.close();
			connection.close();
		}
		catch(SQLException sqle){
			returnValue = false;
		}
		return returnValue;
	}
	private boolean updateServiceRequest(ServiceRequest sr) {
		boolean returnValue = true;
		
		try{
			connection = this.getConnection();
			String qs = "update ServiceRequest set SR_STS='" + sr.getStatus() + "' " +
											"where SRID='" + sr.getSrid() +"'";
					
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(qs);
			stmt.close();
			connection.close();
		}
		catch(SQLException sqle){
			returnValue = false;
		}
		return returnValue;
	}
	@Override
	public List<ServiceRequest> getAllServiceRequests() {
		List<ServiceRequest> list = new ArrayList<ServiceRequest>();
		try{
			connection = this.getConnection();
			if(connection ==null){
				return null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from ServiceRequest");
				while(rs.next()){
					ServiceRequest sr= new ServiceRequest();
					String srid= rs.getString("SRID");
					sr.setSrid(srid);
					sr.setStatus(rs.getInt("SR_STS"));
					sr.setSensors(getAllSensorWithGivenSrid(srid));
					list.add(sr);
				}
				
				stmt.close();
				connection.close();
				}
		}
		catch(SQLException sqle){
			
		}
		
		return list;
	}

	@Override
	public List<Street> getAllStreets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean putStreet(Street st) {
		// TODO Auto-generated method stub
		return false;
	}
	//0 is outstanding
	@Override
	public List<ServiceRequest> getAllOutstandingServiceRequests() {
		List<ServiceRequest> list = new ArrayList<ServiceRequest>();
		try{
			connection = this.getConnection();
			if(connection ==null){
				return null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from ServiceRequest where sr_sts=0");
				while(rs.next()){
					ServiceRequest sr= new ServiceRequest();
					String srid= rs.getString("SRID");
					sr.setSrid(srid);
					sr.setStatus(rs.getInt("SR_STS"));
					sr.setSensors(getAllSensorWithGivenSrid(srid));
					list.add(sr);
				}
				
				stmt.close();
				connection.close();
				}
		}
		catch(SQLException sqle){
			
		}
		
		return list;
	}
	//1 is closed 
	@Override
	public List<ServiceRequest> getAllClosedServiceRequests() {
		List<ServiceRequest> list = new ArrayList<ServiceRequest>();
		try{
			connection = this.getConnection();
			if(connection ==null){
				return null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from ServiceRequest where sr_sts=1");
				while(rs.next()){
					ServiceRequest sr= new ServiceRequest();
					String srid= rs.getString("SRID");
					sr.setSrid(srid);
					sr.setStatus(rs.getInt("SR_STS"));
					sr.setSensors(getAllSensorWithGivenSrid(srid));
					list.add(sr);
				}
				
				stmt.close();
				connection.close();
				}
		}
		catch(SQLException sqle){
			
		}
		return list;
	}
	public List<Sensor> getAllSensorWithGivenSrid(String srid) {
		List<Sensor> list = new ArrayList<Sensor>();
		try{
			connection = this.getConnection();
			if(connection ==null){
				return null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from Sensors where srid="+srid);
				while(rs.next()){
					Sensor s= new Sensor();
					s.setSid(rs.getString("SID"));
					s.setStid(rs.getString("STID"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
					s.setSrid(rs.getString("SRID"));
					list.add(s);
				}

				stmt.close();
				connection.close();
			}
		}
		catch(SQLException sqle){

		}

		return list;

	}
	

}
