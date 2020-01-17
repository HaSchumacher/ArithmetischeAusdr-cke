package View_and_Controller;

import java.util.ArrayList;
import java.util.List;

import Expression.Expression;

public abstract class Observable {
	private List<Observer> observers;
	public Observable() {
		this.observers = new ArrayList<Observer>();
	}
	public void register(Observer o) {
		this.observers.add(o);
	}
	public void deregister(Observer o) {
		this.observers.remove(o);
	}
	public void notifyObservers() {
		for (Observer current: observers) current.update();
	}
	public void excnotify(Exception e) {
		for (Observer current: observers) current.update(e);
	}
	public void notifyevalObservers(int i) {
		for (Observer current: observers) current.update(i);
	}
}
