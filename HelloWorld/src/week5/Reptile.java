package week5;

public abstract class Reptile extends Animal {
	Reptile(String name, float weight) {
		super(name, weight);
	}
	
	abstract String getFood();
}