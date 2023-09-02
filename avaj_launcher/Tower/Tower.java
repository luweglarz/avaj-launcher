package avaj_launcher.Tower;

import java.util.ArrayList;
import avaj_launcher.Flyable.Flyable;

public abstract class Tower {
	private ArrayList<Flyable> observers;

	protected void conditionChanged(){
		for (int i = 0; i < observers.size(); i++){
			observers.get(i).updateConditions();
		}
	}

	public void register(Flyable p_flyable){
		if (!this.observers.contains(p_flyable)){
			observers.add(p_flyable);
			System.out.println("Registered flyable");
		}
		else
			System.out.println("Flyable with this ID already registered");
	}

	public void unregister(Flyable p_flyable){
		if (!this.observers.contains(p_flyable)){
			observers.add(p_flyable);
			System.out.println("Registered flyable");
		}
		else
			System.out.println("Flyable does not exist");
	}
}
