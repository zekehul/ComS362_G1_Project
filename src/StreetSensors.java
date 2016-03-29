package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StreetSensors {

	//This is the UI file for the project //
	public static void main(String[] args) {

		boolean exit = false;
		TownController tc = new TownController();
		
		System.out.print("Welcome to the StreetSensor System\nPlease enter a command:");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(!exit){
			try {
				String cmd = br.readLine();
			
				switch(cmd){
					case "getSensor":
						Sensor s = tc.searchForSensor("00000001");
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
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
