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
						int result = tc.deleteSensor(sidToDelete);
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
