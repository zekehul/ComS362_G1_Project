package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSupport implements DatabaseSupportInterface{

	private Connection connection=null;
	
	@Override
	public boolean putSensor(Sensor s) {
		if(this.getSensor(s.getStreetName(), s.getSection()) == null){
			return createSensor(s);
		}
		else{
			return false;
		}
	}

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
					s.setStreetName(rs.getString("STRT_NME"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
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

	@Override
	public boolean createSensor(Sensor s) {
		boolean returnValue = true;
		
		try{
			connection = this.getConnection();
			String qs = "insert into Sensors values ('" + 
								s.getSid() +"', '" +
								s.getStreetName() +"', " +
								s.getSection() +", " +
								s.getValue() +", " +
								s.getThreshold() +", " +
								s.getStatus() +")";
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
					s.setStreetName(rs.getString("STRT_NME"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
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
					s.setStreetName(rs.getString("STRT_NME"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
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
					s.setStreetName(rs.getString("STRT_NME"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
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

	@Override
	public boolean addServiceRequest(ServiceRequest sr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sensor getSensor(String street, int section) {
		Sensor s = null;
		try{
			connection = this.getConnection();
			if(connection ==null){
				s = null;
			}
			else{
				Statement stmt = connection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from Sensors where STRT_NME='"+street+"' and SECT='" +section+"'");
				if(rs.next()){
					s = new Sensor();
					s.setSid(rs.getString("SID"));
					s.setStreetName(rs.getString("STRT_NME"));
					s.setSection(rs.getInt("SECT"));
					s.setThreshold(rs.getInt("THRSH"));
					s.setValue(rs.getInt("VAL"));
					s.setStatus(rs.getInt("SEN_STS"));
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
	

}