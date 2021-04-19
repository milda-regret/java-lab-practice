public class Book {
	private boolean returned = true;
	
	boolean isReturned() {
		return returned;
	}
	
	void borrow() {
		this.returned = false;
	}
	void _return() {
		this.returned = true;
	}
}