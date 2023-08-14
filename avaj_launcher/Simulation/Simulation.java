package avaj_launcher.Simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import avaj_launcher.Flyable.Aircraft;
import avaj_launcher.Flyable.AircraftFactory;
import avaj_launcher.Flyable.Coordinates;
import avaj_launcher.Flyable.Flyable;

public class Simulation {

	private static int simRepetitions;

	private static Boolean checkLine(ArrayList<String> line){
		if (line.size() != 5)
			return (false);
		try{
			for (int i = 2; i < line.size(); i++){
				Integer.parseInt(line.get(i));
			}
		}
		catch (NumberFormatException e){
			return (false);
		}
		return (true);
	}

	private static Flyable generateAircraft(ArrayList<String> line) throws WrongScenarioFormat{
		if (checkLine(line)){
			Integer newCoordinates[] = { Integer.parseInt(line.get(2)) , Integer.parseInt(line.get(3)), Integer.parseInt(line.get(3)) };
			return AircraftFactory.newAircraft(line.get(0), line.get(1), newCoordinates);
		}
		else
			throw new WrongScenarioFormat("Wrong line format");

	}
	public static void main(String[] args){
		TreeMap<Integer, Flyable> aircrafts = new TreeMap<Integer, Flyable>();

		if (args.length != 1){
			System.out.println("This program takes one argument 'scenario.txt'.");
			return ;
		}
		try {
			File simulatorFile = new File(args[0]);
			Scanner fileScanner = new Scanner(simulatorFile);
			Integer ids = 0;
			simRepetitions = Integer.parseInt(fileScanner.nextLine());
			fileScanner.hasNextLine();
			while (fileScanner.hasNextLine()) {
			  String data = fileScanner.nextLine();
			  List<String> splitted = Arrays.asList(data.split(" "));
			  aircrafts.put(ids++ ,generateAircraft(new ArrayList<String>(splitted)));
			  System.out.println(data);
			}
			fileScanner.close();
		} catch (NumberFormatException | FileNotFoundException | IllegalStateException | WrongScenarioFormat e) {
			System.out.println("An error occurred during file parsing:");
			if (e instanceof NumberFormatException )
				System.out.println("	First line should contain the number of simulation repetition");
			//e.printStackTrace();
		}
	}
}
