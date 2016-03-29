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
				String line = br.readLine();
				Scanner sc = new Scanner(line);
				sc.useDelimiter(",\\s*");
				String cmd = sc.next();
			
				switch(cmd){
				
					case "createServiceRequest":
						List<String> SensorIds = new ArrayList<String>();
						while(sc.hasNext()){
							SensorIds.add(sc.next());
						}
						if(tc.createServiceRequest((String[])SensorIds.toArray())){
							System.out.println("Service Request Created");
						}
						else{
							System.out.println("Operation Failed");
						}
						
						break;
				
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
					
					case "getSensor":
						String sidToSearch = sc.next();
						Sensor s = tc.searchForSensor(sidToSearch);
						System.out.println("Sensor "+s.getSid()+" has value "+s.getValue());
						break;
						
					case "resetSensor":
						boolean success = tc.resetSensor("00000001");
						System.out.println(success);
						break;
						
					case "getAllSensors":
						List<Sensor> list = tc.getAllSensors();
						for(Sensor sen:list){
							System.out.println(sen.getSid());
						}
						break;
						
					case "getCriticalSensors":
						List<Sensor> list1 = tc.getCriticalSensors();
						for(Sensor sen:list1){
							System.out.println(sen.getSid());
						}
						break;
						
					case "getDeadSensors":
						List<Sensor> list2 = tc.getDeadSensors();
						for(Sensor sen:list2){
							System.out.println(sen.getSid());
						}
						break;
						
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
