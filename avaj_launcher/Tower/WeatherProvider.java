package avaj_launcher.Tower;

import avaj_launcher.Flyable.Coordinates;

public class WeatherProvider {
	private String[] weather;

	// WeatherProvider is a static class so it should only have one instance within the program
	private static WeatherProvider instance;

	private WeatherProvider() {
        this.weather = new String[]{ "RAIN", "FOG", "SUN", "SNOW" };
    }

	// Instanciate WeatherProvider static class and return this instance
	public static WeatherProvider getWeatherProvider() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

	// Algorithm to generate the weather based on p_coordinates
	public String getCurrentWeather(Coordinates p_coordinates){
		int sum = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();

		return (this.weather[sum % 4]);
	}

}