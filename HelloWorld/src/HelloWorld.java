public class HelloWorld {

	public static void main(String[] args) {
		Library lib = new Library();
		lib.borrowBook(0);
		lib.returnBook(0);
		lib.borrowBook(1);
		lib.borrowBook(1);
		lib.returnBook(2);
	}
}
