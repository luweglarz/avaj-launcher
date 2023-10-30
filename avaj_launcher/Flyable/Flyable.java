package avaj_launcher.Flyable;

import avaj_launcher.Tower.WeatherTower;

/*
	Abstract class Flyable is the supplier of the realization relationship between Aircraft and Flyable
*/
public abstract class Flyable {
	protected WeatherTower weatherTower;

	public abstract void updateConditions();
	
	public abstract void registerTower(WeatherTower p_tower);

	public abstract String getName();

	public abstract long getId();

};