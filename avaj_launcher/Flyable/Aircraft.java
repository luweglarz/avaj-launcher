package avaj_launcher.Flyable;

import avaj_launcher.Tower.WeatherTower;

/*
	Class Aircraft is the supplier of the realization relationship between Aircraft and Flyable
*/
public class Aircraft extends Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates){
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	public void registerTower(WeatherTower p_tower){
		this.weatherTower = p_tower;
		this.weatherTower.register(this);
	}

	public void updateConditions(){}

	public String getName(){
		return (this.name);
	}

	public long getId(){
		return (this.id);
	}
}
