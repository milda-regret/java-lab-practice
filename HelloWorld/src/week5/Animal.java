package week5;

public class Animal {
	private String name;
	private float weight;
	
	Animal(String name, float weight) {
		this.name = name;
		this.weight = weight;
	}
	
	String getName() {
		return this.name;
	}
	void setName(String name) {
		this.name = name;
	}
	float getWeight() {
		return this.weight;
	}
	void setWeight(float weight) {
		this.weight = weight;
	}
}