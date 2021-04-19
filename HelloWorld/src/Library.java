public class Library {
	private Book[] books = new Book[10];
	
	public void borrowBook(int n) {
		if(books[n].isReturned()) {
			books[n].borrow();
			System.out.println("succes");
		}
		else {
			System.out.println("already borrowed!!");
		}
	}
	public void returnBook(int n) {
		if(books[n].isReturned()) {
			System.out.println("already returned!!");
		}
		else {
			books[n]._return();
			System.out.println("succes");
		}
	}
	
	Library() {
		for(int i=0; i<10; ++i) {
			books[i] = new Book();
		}
	}
}