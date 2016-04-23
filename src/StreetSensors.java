package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreetSensors {

	//This is the UI file for the project //
	public static void main(String[] args) {

		boolean exit = false;
		TownController tc = new TownController();
		
		System.out.print("Welcome to the StreetSensor System\nPlease enter a command:");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(!exit){
			try {
				//System reads the command given, arguments are read in each case
				String line = br.readLine();
				Scanner sc = new Scanner(line);
				sc.useDelimiter(",\\s*");
				String cmd = sc.next();
			
				switch(cmd){
				
					//Command: getAllStreets
					case "getAllStreets":
						List<Street> streets = tc.getAllStreets();
						System.out.println("Street ID    Street Name");
						for(Street s:streets){
							System.out.println(s.getStid()+"     "+s.getName());
						}
						break;
				
					//Command: updateStreet, street name, new name
					case "updateStreet":
						String stToUpdate = sc.next();
						String newName = sc.next();
						if(tc.updateStreet(stToUpdate, newName)){
							System.out.println(stToUpdate+" was changed to "+newName);
						}
						else{
							System.out.println("Operation Failed");
						}
						break;
					
				
					//Command: deleteStreet, street name
					case "deleteStreet":
						String stToDelete = sc.next();
						int result = tc.deleteStreet(stToDelete);
						switch(result){
							case -1:
								System.out.println("Database Error");
								break;
							case 0:
								System.out.println(stToDelete+" deleted");
								break;
							case 1:
								System.out.println("No such sensor exists");
								break;
						}
				
					//Command addStreet, street ID #, street name
					case "addStreet":
						String stidToAdd = sc.next();
						String stName = sc.next();
						if(tc.addStreet(stidToAdd, stName)){
							System.out.println(stName+" created with ID "+stidToAdd);
						}
						else{
							System.out.println("Operation Failed");
						}
						break;
				
					//Command: getAllClosedServiceRequests
					case "getAllClosedServiceRequests":
						List<ServiceRequest> csrList = tc.getAllClosedServiceRequests();
						System.out.println("The following Service Requests are Closed:");
						String closedOutput = "";
						for(ServiceRequest sr:csrList){
							closedOutput = closedOutput+sr.getSrid()+"  ";
						}
						System.out.println(closedOutput);
						break;
				
					//Command: getAllOutstandingServiceRequests
					case "getAllOutstandingServiceRequests":
						List<ServiceRequest> osrList = tc.getAllOutstandingServiceRequests();
						System.out.println("The following Service Requests are Outstanding:");
						String outstandingOutput = "";
						for(ServiceRequest sr:osrList){
							outstandingOutput = outstandingOutput+sr.getSrid()+"  ";
						}
						System.out.println(outstandingOutput);
						break;
				
					//Command: getAllServiceRequests
					case "getAllServiceRequests":
						List<ServiceRequest> srList = tc.getAllServiceRequests();
						for(ServiceRequest sr:srList){
							if(sr.getStatus()==0){
								System.out.println("Service Request "+sr.getSrid()+" - Status - Outstanding");
							}
							else{
								System.out.println("Service Request "+sr.getSrid()+" - Status - Closed");
							}
						}
						break;
				
					//Command: searchServiceRequest, SR ID #
					case "searchServiceRequest":
						String sridToFind = sc.next();
						ServiceRequest sr = tc.searchServiceRequest(sridToFind);
						if(sr.getStatus()==0){
							System.out.println("Service Request "+sridToFind+" - Status - Outstanding");
						}
						else{
							System.out.println("Service Request "+sridToFind+" - Status - Closed");
						}
						for(Sensor s:sr.getSensors()){
							System.out.println(s.getSid());
						}
						break;
				
					//Command: updateServiceRequest, SR ID #, "Outstanding"/"Closed"
					case "updateServiceRequest":
						String sridToUpdate = sc.next();
						String status = sc.next();
						if(status.equals("Outstanding")){
							if(tc.updateServiceRequest(sridToUpdate, 0)){
								System.out.println("Service Request "+sridToUpdate+" updated");
							}
							else{
								System.out.println("Operation Failed");
							}
						}
						else if(status.equals("Closed")){
							if(tc.updateServiceRequest(sridToUpdate, 1)){
								System.out.println("Service Request "+sridToUpdate+" updated");
							}
							else{
								System.out.println("Operation Failed");
							}
						}
						else{
							System.out.println("Please enter 'Outstanding' or 'Closed' when updating a Service Request");
							break;
						}
							
						break;
				
					//Command: createServiceRequest, ID #, Sensor ID 1, Sensor ID 2, ...etc
					case "createServiceRequest":
						List<String> SensorIds = new ArrayList<String>();
						String newSRId = sc.next(); 
						while(sc.hasNext()){
							SensorIds.add(sc.next());
						}
						if(tc.createServiceRequest(newSRId, SensorIds.toArray(new String[SensorIds.size()]))){
							System.out.println("Service Request Created");
						}
						else{
							System.out.println("Operation Failed");
						}
						
						break;
				
					//Command: updateStrain, Sensor ID, new strain value
					case "updateStrain":
						String sidToUpdate = sc.next();
						int newStrain = sc.nextInt();
						if(tc.updateStrain(sidToUpdate, newStrain)){
							System.out.println("Sensor "+sidToUpdate+" strain updated to "+newStrain);
						}
						else{
							System.out.println("Update Failed");
						}
						break;
				
					//Command: addSensor, Sensor ID, Street Name, Section number, threshold
					case "addSensor": 
						String sidToCreate = sc.next();
						String street = sc.next();
						int sect = sc.nextInt();
						int threshold = sc.nextInt();
						
						if(tc.addSensor(sidToCreate, street, sect, threshold)){
							System.out.println("Sensor created at " +street+ ", Sect "+ sect+ ", THRSH="+threshold);
						}
						else{
							System.out.println("A Sensor already exists at that location");
						}
						break;
					
					//Command: deleteSensor, Sensor ID
					case "deleteSensor":
						String sidToDelete = sc.next();
						result = tc.deleteSensor(sidToDelete);
						switch(result){
							case -1:
								System.out.println("Database Error");
								break;
							case 0:
								System.out.println("Sensor "+sidToDelete+" deleted");
								break;
							case 1:
								System.out.println("No such sensor exists");
								break;
						}
						break;
					
					//Command: getSensor, Sensor ID
					case "getSensor":
						String sidToSearch = sc.next();
						Sensor s = tc.searchForSensor(sidToSearch);
						System.out.println("Sensor "+s.getSid()+" has value "+s.getValue());
						break;
					
					//Command: resetSensor, Sensor ID
					case "resetSensor":
						String sidToReset = sc.next();
						if(tc.resetSensor(sidToReset)){
							System.out.println("Sensor "+sidToReset+" was reset");
						}
						else{
							System.out.println("Operation Failed");
						}
						break;
					
					//Command: getAllSensors
					case "getAllSensors":
						List<Sensor> list = tc.getAllSensors();
						System.out.println("ID________VALUE__");
						for(Sensor sen:list){
							System.out.println(sen.getSid()+ "  " + sen.getValue());
						}
						break;
					
					//Command: getCriticalSensors
					case "getCriticalSensors":
						List<Sensor> list1 = tc.getCriticalSensors();
						for(Sensor sen:list1){
							System.out.println(sen.getSid());
						}
						break;
					
					//Command: getDeadSensors
					case "getDeadSensors":
						List<Sensor> list2 = tc.getDeadSensors();
						for(Sensor sen:list2){
							System.out.println(sen.getSid());
						}
						break;
					
					//Exits the Application
					case "exit": exit = true; 
						break;
						
					default:
						System.out.println("Command not found");
						break;
				}
				
				sc.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
