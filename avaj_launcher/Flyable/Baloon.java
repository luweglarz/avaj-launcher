package avaj_launcher.Flyable;

public class Baloon extends Aircraft{
	public Baloon(long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
	}

	private void unregisterTower(){
		this.weatherTower.unregister(this);
	}

	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(this.coordinates);
		String [] classes = this.getClass().getName().split("\\.");

		if (currentWeather.equals("SUN")){
			if ((this.coordinates.getHeight() + 4) >= 100)
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), 100);
			else
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
			System.out.println(classes[classes.length - 1] + "#" + this.name + "(" + id + ")" + ": Let's enjoy the good weather and take some pics.");
		}
		else if (currentWeather.equals("RAIN")){
			if ((this.coordinates.getHeight() - 5) <= 0){
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
				System.out.println(classes[classes.length - 1] + "#" + this.name + "(" + id + ")" + ": Landing at: " + this.coordinates.getLongitude() + "," + this.coordinates.getLatitude());
				this.unregisterTower();
			}
			else{
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
				System.out.println(classes[classes.length - 1] + "#" + this.name + "(" + id + ")" + ": Damn you rain! You messed up my baloon.");
			}
		}
		else if (currentWeather.equals("FOG")){
			if ((this.coordinates.getHeight() - 3) <= 0){
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
				System.out.println(classes[classes.length - 1] + "#" + this.name + "(" + id + ")" + ": Landing at: " + this.coordinates.getLongitude() + "," + this.coordinates.getLatitude());
				this.unregisterTower();
			}
			else{
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
				System.out.println(classes[classes.length - 1] + "#" + this.name + "(" + id + ")" + ": Damn you fog!");
			}
		}
		else if (currentWeather.equals("SNOW")){
			if ((this.coordinates.getHeight() - 15) <= 0){
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
				System.out.println(classes[classes.length - 1] + "#" + this.name + "(" + id + ")" + ": Landing at: " + this.coordinates.getLongitude() + "," + this.coordinates.getLatitude());
				this.unregisterTower();
			}
			else{
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
				System.out.println(classes[classes.length - 1] + "#" + this.name + "(" + id + ")" + ": It's snowing. We're gonna crash.");
			}
		}
	}
}
