package avaj_launcher.Simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Simulation {

	private static int simRepetitions;
	private static ArrayList<String> idList = new ArrayList<>();

	private static Boolean checkLineFormat(ArrayList<String> line){
		if (line.size() != 5)
			return (false);
		String newId = line.get(1);
		if (idList.contains(newId))
			return (false);
		else
			idList.add(newId);
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
	public static void main(String[] args) throws FileNotFoundException{
		if (args.length != 1){
			System.out.println("This program takes one argument 'scenario.txt'.");
			return ;
		}
		try {
			File simulatorFile = new File(args[0]);
			Scanner fileScanner = new Scanner(simulatorFile);
			simRepetitions = Integer.parseInt(fileScanner.nextLine());
			fileScanner.hasNextLine();
			while (fileScanner.hasNextLine()) {
			  String data = fileScanner.nextLine();
			  List<String> splitted = Arrays.asList(data.split(" "));
			  if (checkLineFormat(new ArrayList<String>(splitted))){

			  }
			  else{
				System.out.println("Wrong line format");
				fileScanner.close();
				return ;
			  }
			  System.out.println(data);
			}
			fileScanner.close();
		} catch (NumberFormatException | FileNotFoundException | IllegalStateException e) {
			System.out.println("An error occurred during file parsing:");
			if (e instanceof NumberFormatException )
				System.out.println("	First line should contain the number of simulation repetition");
			//e.printStackTrace();
		}
	}
}
