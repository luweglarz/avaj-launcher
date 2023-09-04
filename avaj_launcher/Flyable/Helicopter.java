package avaj_launcher.Flyable;

public class Helicopter extends Aircraft{
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(this.coordinates);
		
		if (currentWeather.equals("SUN")){
			if ((this.coordinates.getHeight() + 2) >= 100)
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), 100);
			else
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
			System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": This is hot.");
		}
		else if (currentWeather.equals("RAIN")){
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
			System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Damn you rain! You messed up my rotor.");
		}
		else if (currentWeather.equals("FOG")){
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
			System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Damn you fog!");
		}
		else if (currentWeather.equals("SNOW")){
			if ((this.coordinates.getHeight() - 12) <= 0)
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
			else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
			System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": My rotor is going to freeze!");
		}
	}

	public String getName(){
		return (this.name);
	}

	public long getId(){
		return (this.id);
	}

	public String getType(){
		return ("Helicopter");
	}
}
