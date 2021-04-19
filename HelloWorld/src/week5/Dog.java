package week5;

public final class Dog extends Mammal {
	private String nameOfMaster;
	
	Dog(String name, float weight, String nameOfMaster) {
		super(name, weight);
		this.nameOfMaster = nameOfMaster;
	}
	
	void bark() {
		System.out.println("Bowbow");
	}
	String getFood() {
		return "Apple";
	}
	String getNameOfSlave() {
		return this.nameOfMaster;
	}
	void setNameOfSlave(String name) {
		this.nameOfMaster = name;
	}
}