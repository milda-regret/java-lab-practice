package week5;

public final class Cat extends Mammal {
	private String nameOfSlave;
	
	Cat(String name, float weight, String nameOfSlave) {
		super(name, weight);
		this.nameOfSlave = nameOfSlave;
	}
	
	void bark() {
		System.out.println("Meow");
	}
	String getFood() {
		return "Fish";
	}
	String getNameOfSlave() {
		return this.nameOfSlave;
	}
	void setNameOfSlave(String name) {
		this.nameOfSlave = name;
	}
}