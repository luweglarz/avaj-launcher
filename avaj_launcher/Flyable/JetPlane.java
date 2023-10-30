package avaj_launcher.Flyable;

public class JetPlane extends Aircraft{
	public JetPlane(long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
	}

	private void unregisterTower(){
		this.weatherTower.unregister(this);
	}

	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(this.coordinates);
		
		if (currentWeather.equals("SUN")){
			if ((this.coordinates.getHeight() + 2) >= 100)
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, 100);
			else
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
			System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ": This is hot.");
		}
		else if (currentWeather.equals("RAIN")){
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
			System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ": It's raining. Better watch out for lightings.");
		}
		else if (currentWeather.equals("FOG")){
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
			System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ": Damn you fog!");
		}
		else if (currentWeather.equals("SNOW")){
			if ((this.coordinates.getHeight() - 7) <= 0){
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
				System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ": Landing at: " + this.coordinates.getLongitude() + "," + this.coordinates.getLatitude());
				this.unregisterTower();
			}
			else{
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
				System.out.println(this.classes[classes.length - 1] + "#" + this.name + "(" + this.id + ")" + ":  OMG! Winter is coming!");
			}
		}
	}

	private String [] classes = this.getClass().getName().split("\\.");
}
