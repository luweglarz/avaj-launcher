package avaj_launcher.Flyable;

import avaj_launcher.Tower.WeatherTower;

//Flyable is an interface because Airfract has a low dependecy toward Flyable so it cannot be an abstract class
public interface Flyable {
	public abstract void updateConditions();
	
	public void registerTower(WeatherTower p_tower);

	public String getName();

	public long getId();

	public String getType();

};