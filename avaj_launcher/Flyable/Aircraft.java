package avaj_launcher.Flyable;

import avaj_launcher.Tower.WeatherTower;

//The dependency arrow between Aircraft and Flyable means that Flyable has to be implemented and not extended into Aircraft
//Aircraft isn't mean to be instancied so it is declared as an abstract class
public class Aircraft extends Flyable{
	protected long id;
	protected String name;
	protected String type;
	protected Coordinates coordinates;

	public WeatherTower weatherTower;

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
