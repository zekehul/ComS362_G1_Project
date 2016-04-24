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
				//Command: getAllSensorsInStreet, stid
				case "getSensorsInStreet":
					String stidToGetSensors = sc.next();
					List<Sensor> sensorsInStreet = tc.getSensorsInStreet(stidToGetSensors);
					System.out.println("Sensors in Street with stid "+stidToGetSensors);
					System.out.println("ID________VALUE__");
					for(Sensor sen:sensorsInStreet){
						System.out.println(sen.getSid()+ "  " + sen.getValue());
					}
					break;
				//Command: getAllBridges, bid
				case "getSensorsInBridge":
					String bidToGetSensors = sc.next();
					List<Sensor> sensorsInBridge = tc.getSensorsInBridge(bidToGetSensors);
					System.out.println("Sensors in Bridge with bid "+bidToGetSensors);
					System.out.println("ID________VALUE__");
					for(Sensor sen:sensorsInBridge){
						System.out.println(sen.getSid()+ "  " + sen.getValue());
					}
					break;
				//Command: getAllBridges, srid
				case "getSensorsInServiceRequest":
					String sridToGetSensors = sc.next();
					List<Sensor> sensorsInServiceRequest = tc.getSensorsInServiceRequest(sridToGetSensors );
					System.out.println("Sensors in Service Request with srid "+sridToGetSensors );
					System.out.println("ID________VALUE__");
					for(Sensor sen:sensorsInServiceRequest){
						System.out.println(sen.getSid()+ "  " + sen.getValue());
					}
					break;
				//Command: getAllBridges
				case "getAllBridges":
					List<Bridge> bridges = tc.getAllBridges();
					System.out.println("Bridge ID    Bridge Name");
					for(Bridge bridge:bridges){
						System.out.println(bridge.getBid()+"     "+bridge.getName());
					}
					break;

					//Command: updateBridge, bid, new name
				case "updateBridge":
					String bidToUpdate = sc.next();
					String newBridgeName = sc.next();
					if(tc.updateBridge(bidToUpdate, newBridgeName)){
						System.out.println(bidToUpdate+"'s bridge name was changed to "+newBridgeName);
					}
					else{
						System.out.println("Operation Failed");
					}
					break;


					//Command: deleteBridge, bid
				case "deleteBridge":
					String brToDelete = sc.next();
					int result = tc.deleteBridge(brToDelete);
					switch(result){
					case -1:
						System.out.println("Database Error");
						break;
					case 0:
						System.out.println(brToDelete+" deleted");
						break;
					case 1:
						System.out.println("No such Bridge exists");
						break;
					}
					break;
					//Command addBridge, Bridge ID #, Bridge name
				case "addBridge":
					String bidToAdd = sc.next();
					String brName = sc.next();
					if(tc.addBridge(bidToAdd, brName)){
						System.out.println(brName+" created with ID "+bidToAdd);
					}
					else{
						System.out.println("Operation Failed");
					}
					break;
					//Command: getAllStreets
				case "getAllStreets":
					List<Street> streets = tc.getAllStreets();
					System.out.println("Street ID    Street Name");
					for(Street s:streets){
						System.out.println(s.getStid()+"     "+s.getName());
					}
					break;

					//Command: updateStreet, stid, new name
				case "updateStreet":
					String stid = sc.next();
					String newName = sc.next();
					if(tc.updateStreet(stid, newName)){
						System.out.println(stid+"'s street name was changed to "+newName);
					}
					else{
						System.out.println("Operation Failed");
					}
					break;


					//Command: deleteStreet, stid
				case "deleteStreet":
					String stToDelete = sc.next();
					int result1 = tc.deleteStreet(stToDelete);
					switch(result1){
					case -1:
						System.out.println("Database Error");
						break;
					case 0:
						System.out.println(stToDelete+" deleted");
						break;
					case 1:
						System.out.println("No such street exists");
						break;
					}
					break;
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
