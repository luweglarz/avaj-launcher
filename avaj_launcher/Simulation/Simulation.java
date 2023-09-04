package avaj_launcher.Simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import avaj_launcher.Flyable.AircraftFactory;
import avaj_launcher.Flyable.Flyable;
import avaj_launcher.Tower.WeatherTower;

public class Simulation {

	private static int simRepetitions;

	private static Boolean checkLine(ArrayList<String> line){
		if (line.size() != 5)
			return (false);
		if (line.get(0).equals("Baloon") && line.get(0).equals("Helicopter") && line.get(0).equals("JetPlane"))
			return (false);
		try{
			for (int i = 2; i < line.size(); i++)
				Integer.parseInt(line.get(i));
		}
		catch (NumberFormatException e){
			return (false);
		}
		return (true);
	}

	private static Flyable generateAircraft(ArrayList<String> line, Integer id) throws WrongScenarioFormat{
		if (checkLine(line)){
			Integer newCoordinates[] = { Integer.parseInt(line.get(2)) , Integer.parseInt(line.get(3)), Integer.parseInt(line.get(3)) };
			return AircraftFactory.newAircraft(line.get(0), id, line.get(1), newCoordinates);
		}
		else
			throw new WrongScenarioFormat("Wrong line format");

	}

	private static void parseScenario(String fileName, WeatherTower weatherTower){
		try {
			File simulatorFile = new File(fileName);
			Scanner fileScanner = new Scanner(simulatorFile);
			int ids = 1;

			simRepetitions = Integer.parseInt(fileScanner.nextLine());
			fileScanner.hasNextLine();
			while (fileScanner.hasNextLine()) {
			  String data = fileScanner.nextLine();
			  List<String> splitted = Arrays.asList(data.split(" "));
			  weatherTower.register(generateAircraft(new ArrayList<String>(splitted), ids++));
			}
			fileScanner.close();
		} catch (NumberFormatException | FileNotFoundException | IllegalStateException | WrongScenarioFormat e) {
			System.out.println("An error occurred during file parsing:");
			if (e instanceof NumberFormatException )
				System.out.println("	First line should contain the number of simulation repetition");
			else if (e instanceof WrongScenarioFormat)
				System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args){
		WeatherTower weatherTower = new WeatherTower();

		if (args.length != 1){
			System.out.println("This program takes one argument 'scenario.txt'.");
			return ;
		}
		else
			parseScenario(args[0], weatherTower);
	}
}
