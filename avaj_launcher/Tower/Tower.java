package avaj_launcher.Tower;

import java.util.ArrayList;
import avaj_launcher.Flyable.Flyable;

/*
	Tower has an aggregate relationship with Flyable, it is composed of flyables but flyables behave on their own
*/
public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	protected void conditionChanged(){
		for (int i = 0; i < observers.size(); i++){
			this.observers.get(i).updateConditions();
		}
	}

	public void register(Flyable p_flyable){
		if (!this.observers.contains(p_flyable)){
			this.observers.add(p_flyable);
			System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower");
		}
		else
			System.out.println("This flyable with this ID already registered");
	}

	public void unregister(Flyable p_flyable){
		if (this.observers.contains(p_flyable)){
			this.observers.remove(p_flyable);
			System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") unregistered from weather tower");
		}
		else
			System.out.println("This flyable does not exist");
	}
}
