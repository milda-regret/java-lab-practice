package lp7;

import java.util.Scanner;

public class SimpleCalculator {
	public static void main(String[] args) {
		int a, b, res;
		String ans, symbol;
		Scanner scn = new Scanner(System.in);
		ans = scn.nextLine();
		if(ans.contains("+")) {
			symbol = "\\+";
		}
		else {
			symbol = "-";
		}
		a = Integer.parseInt(ans.split(symbol)[0]);
		b = Integer.parseInt(ans.split(symbol)[1]);
		try {
			if(symbol.equals("\\+")) {
				if(a == 0 || b == 0) {
					throw new AddZeroException();
				}
				res = a + b;
			}
			else {
				if(a == 0 || b == 0) {
					throw new SubtractZeroException();
				}
				res = a - b;
			}
			if(a < 0 || a > 1000 || b < 0 || b > 1000 || res < 0 || res > 1000) {
				throw new OutOfRangeException();
			}
			System.out.println(res);
		}
		catch(AddZeroException e) {
			System.out.println("AddZeroException");
		}
		catch(SubtractZeroException e) {
			System.out.println("SubtractZeroException");
		}
		catch(OutOfRangeException e) {
			System.out.println("OutOfRangeException");
		}
	}
}

class OutOfRangeException extends Exception {
	
}

class AddZeroException extends Exception {
	
}
class SubtractZeroException extends Exception {
	
}