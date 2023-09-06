package avaj_launcher.Flyable;

public class JetPlane extends Aircraft{
	public JetPlane(long p_id, String p_name, String p_type, Coordinates p_coordinate){
		super(p_id, p_name, p_type, p_coordinate);
	}

	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(this.coordinates);
		
		if (currentWeather.equals("SUN")){
			if ((this.coordinates.getHeight() + 2) >= 100)
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, 100);
			else
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
			System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": This is hot.");
		}
		else if (currentWeather.equals("RAIN")){
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
			System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": It's raining. Better watch out for lightings.");
		}
		else if (currentWeather.equals("FOG")){
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
			System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Damn you fog!");
		}
		else if (currentWeather.equals("SNOW")){
			if ((this.coordinates.getHeight() - 7) <= 0){
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
				System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Landing.");
			}
			else{
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
				System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ":  OMG! Winter is coming!");
			}
		}
	}
}
