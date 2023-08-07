package avaj_launcher.Flyable;

import avaj_launcher.Flyable.Flyable;
import avaj_launcher.Coordinates;

public class AircraftFactory {
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
		return (new Baloon(0, p_name, p_coordinates));
	}
}
