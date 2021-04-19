package week5;

public class test {
	public static void main(String[] args) {
		
		Cat cat = new Cat("Navi", (float) 3.3, "Sewon");
		Dog dog = new Dog("Mung", (float) 5.9, "Jongwoo");
		Crocodile croc = new Crocodile("Coco", (float) 11.1);
		
		cat.bark();
		dog.bark();
		
		System.out.println(cat.getName());
		System.out.println(cat.getWeight());
		System.out.println(cat.getNameOfSlave());
		System.out.println(cat.getFood());
		
		System.out.println(dog.getName());
		System.out.println(dog.getWeight());
		System.out.println(dog.getNameOfSlave());
		System.out.println(dog.getFood());
		
		System.out.println(croc.getFood());
		System.out.println(croc.getName());
		System.out.println(croc.getWeight());
	}
}