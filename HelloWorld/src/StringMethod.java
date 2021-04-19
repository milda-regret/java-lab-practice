
public class StringMethod {
	
	// Returns a string created by adding 's2' after position 'index' of 's1'.
	
	static String addString(String s1, int index, String s2) {
		return s1.substring(0, index+1).concat(s2).concat(s1.substring(index+1, s1.length()));
	}
	
	
	// Returns a reversed string of 's'
	
	static String reverse(String s) {
		String r = new String("");
		for(int i=0; i < s.length(); ++i) {
			r = s.substring(i, i+1).concat(r);
		}
		return r;
	}
	
	
	// Returns a string removed all 's2' tokens from 's1'
	
	static String removeString(String s1, String s2) {
		int i = 0;
		while(i < s1.length() - s2.length()) {
			if(s2.equals(s1.substring(i, i+s2.length()))) {
				s1 = s1.substring(0, i).concat(s1.substring(i+s2.length()));
			}
			else {
				++i;
			}
		}
		return s1;
	}
	
	public static void main(String[] args) {
		System.out.println(addString("0123456", 3, "-"));
		System.out.println(reverse("abc"));
		System.out.println(removeString("01001000", "00"));
	}
}