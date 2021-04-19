package week5;

public final class Crocodile extends Reptile {
	Crocodile(String name, float weight) {
		super(name, weight);
	}
	
	String getFood() {
		return "Meat";
	}
}