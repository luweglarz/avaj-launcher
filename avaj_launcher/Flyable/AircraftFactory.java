package avaj_launcher.Flyable;

import avaj_launcher.Flyable.Flyable;

public abstract class AircraftFactory {
	//Since Coordinate cannot be instancied outside of the Flyable package I changed the 3rd arguments with an array of interger
	public static Flyable newAircraft(String p_type, String p_name, Integer coordinates[]){
		Coordinates newCoordinates = new Coordinates(coordinates[0], coordinates[1], coordinates[2]);
		return (new Baloon(0, p_name, newCoordinates));
	}
}
