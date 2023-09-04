package avaj_launcher.Flyable;

import avaj_launcher.Tower.WeatherTower;

//The dependency arrow between Aircraft and Flyable means that Flyable has to be implemented and not extended into Aircraft
//Aircraft isn't mean to be instancied so it is declared as an abstract class
public abstract class Aircraft implements Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	public WeatherTower weatherTower;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates){
		this.id = p_id;
		this.name = p_name;
		this. coordinates = p_coordinates;
	}

	public void registerTower(WeatherTower p_tower){
		this.weatherTower = p_tower;
		this.weatherTower.register(this);
	}

	public void unregisterTower(){
		this.weatherTower.unregister(this);
	}
}
