package avaj_launcher.Tower;
import avaj_launcher.Flyable.Coordinates;

public class WeatherProvider {
	static private String[] weather = new String[]{ "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {
    }

	// Algorithm to generate the weather based on p_coordinates
	public static String getCurrentWeather(Coordinates p_coordinates){
		int sum = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();
		sum += (int)System.currentTimeMillis();
		if (sum < 0)
			sum = sum * -1;
		return (weather[sum % 3]);
	}

}