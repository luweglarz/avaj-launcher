package avaj_launcher.Flyable;

import avaj_launcher.Tower.WeatherTower;

public class Aircraft extends Flyable{
	protected long id;
	protected String name;
	protected String type;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, String p_type, Coordinates p_coordinates){
		this.id = p_id;
		this.name = p_name;
		this.type = p_type;
		this. coordinates = p_coordinates;
	}

	public void registerTower(WeatherTower p_tower){
		this.weatherTower = p_tower;
		this.weatherTower.register(this);
	}

	public void unregisterTower(){
		this.weatherTower.unregister(this);
	}

	public void updateConditions(){}

	public String getName(){
		return (this.name);
	}

	public long getId(){
		return (this.id);
	}

	public String getType(){
		return (this.type);
	}
}
