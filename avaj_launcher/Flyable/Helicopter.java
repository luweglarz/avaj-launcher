package avaj_launcher.Flyable;

public class Helicopter extends Aircraft{
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
	}

	private void unregisterTower(){
		this.weatherTower.unregister(this);
	}

	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(this.coordinates);
		
		if (currentWeather.equals("SUN")){
			if ((this.coordinates.getHeight() + 2) >= 100)
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), 100);
			else
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
			System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ": This is hot.");
		}
		else if (currentWeather.equals("RAIN")){
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
			System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ": Damn you rain! You messed up my rotor.");
		}
		else if (currentWeather.equals("FOG")){
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
			System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ": Damn you fog!");
		}
		else if (currentWeather.equals("SNOW")){
			if ((this.coordinates.getHeight() - 12) <= 0){
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
				System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ": Landing at: " + this.coordinates.getLongitude() + "," + this.coordinates.getLatitude());
				this.unregisterTower();
			}
			else{
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
				System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ": My rotor is going to freeze!");
			}
		}
	}

	private String [] classes = this.getClass().getName().split("\\.");
}
