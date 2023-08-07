package avaj_launcher.Tower;

import java.util.ArrayList;
import avaj_launcher.Flyable.Flyable;

public abstract class Tower {
	private ArrayList<Flyable> observers;

	protected void conditionChanged(){
		
	}

	public void register(Flyable p_flyable){

	}

	public void unregister(Flyable p_Flyable){

	}
}
