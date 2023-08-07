package avaj_launcher.Flyable;

import avaj_launcher.Tower.WeatherTower;

public abstract class Flyable {

	protected WeatherTower weatherTower;

	public abstract void updateConditions();
	
	public void registerTower(WeatherTower p_tower){

	}

};