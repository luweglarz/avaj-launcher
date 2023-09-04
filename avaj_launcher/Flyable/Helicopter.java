package avaj_launcher.Flyable;

public class Helicopter extends Aircraft{
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions(){

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
