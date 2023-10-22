package avaj_launcher.Flyable;

public class AircraftFactory {
	//Since Coordinate cannot be instancied outside of the Flyable package I changed the 3rd arguments with an array of interger
	public static Flyable newAircraft(String p_type, Integer p_id, String p_name, Integer coordinates[]){
		Coordinates newCoordinates = new Coordinates(coordinates[0], coordinates[1], coordinates[2]);

		if (coordinates[2] > 100)
			coordinates[2] = 100;
		if (p_type.equals("Baloon"))
			return (new Baloon(p_id, p_name, p_type, newCoordinates));
		else if (p_type.equals("Helicopter"))
			return (new Helicopter(p_id, p_type, p_name, newCoordinates));
		return (new JetPlane(p_id, p_type, p_name, newCoordinates));
	}
}
