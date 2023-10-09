package avaj_launcher.Flyable;

import avaj_launcher.Tower.WeatherTower;

public abstract class Flyable {
	public WeatherTower weatherTower;

	public abstract void updateConditions();
	
	public abstract void registerTower(WeatherTower p_tower);

	public abstract String getName();

	public abstract long getId();

	public abstract String getType();

};