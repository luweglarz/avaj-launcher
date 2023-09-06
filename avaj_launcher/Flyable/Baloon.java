package avaj_launcher.Flyable;

public class Baloon extends Aircraft{
	public Baloon(long p_id, String p_name, String p_type, Coordinates p_coordinate){
		super(p_id, p_name, p_type, p_coordinate);
	}

	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(this.coordinates);
			
		if (currentWeather.equals("SUN")){
			if ((this.coordinates.getHeight() + 4) >= 100)
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), 100);
			else
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
			System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Let's enjoy the good weather and take some pics.");
		}
		else if (currentWeather.equals("RAIN")){
			if ((this.coordinates.getHeight() - 5) <= 0){
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
				System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Landing.");
			}
			else{
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
				System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Damn you rain! You messed up my baloon.");
			}
		}
		else if (currentWeather.equals("FOG")){
			if ((this.coordinates.getHeight() - 3) <= 0){
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
				System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Landing.");
			}
			else{
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
				System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Damn you fog!");
			}
		}
		else if (currentWeather.equals("SNOW")){
			if ((this.coordinates.getHeight() - 15) <= 0){
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
				System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": Landing.");
			}
			else{
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
				System.out.println(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + ": It's snowing. We're gonna crash.");
			}
		}
	}
	
	// public String getName(){
	// 	return (this.name);
	// }

	// public long getId(){
	// 	return (this.id);
	// }

	// public String getType(){
	// 	return ("Baloon");
	// }
}
