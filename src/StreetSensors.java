package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
