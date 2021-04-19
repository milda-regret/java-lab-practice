package week5;

public abstract class Mammal extends Animal {
	Mammal(String name, float weight) {
		super(name, weight);
	}
	
	abstract void bark();
	abstract String getFood();
}