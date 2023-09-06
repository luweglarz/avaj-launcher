package avaj_launcher.Flyable;

import avaj_launcher.Tower.WeatherTower;

//Flyable is an interface because Airfract has a low dependecy toward Flyable so it cannot be an abstract class
public abstract class Flyable {
	public abstract void updateConditions();
	
	public abstract void registerTower(WeatherTower p_tower);

	public abstract String getName();

	public abstract long getId();

	public abstract String getType();

};