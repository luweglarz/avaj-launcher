package avaj_launcher.Tower;

import avaj_launcher.Flyable.Coordinates;;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates p_coordinates){
		return (WeatherProvider.getCurrentWeather(p_coordinates));
	}

	public void changeWeather(){
		this.conditionChanged();
	}
}
