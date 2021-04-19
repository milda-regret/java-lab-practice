package week6;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Contact {
	
	static HashMap<String, String> list = new HashMap<>();
	
	static void show() {
		Object[] keys = list.keySet().toArray();
		Arrays.sort(keys);
		for (Object key : keys) {
			System.out.println(key + " " +list.get(key));
		}
	}
	static void find(String name) {
		System.out.println(list.get(name));
	}
	static void add(String name, String num) {
		if (list.containsKey(name)) {
			System.out.println("error");
			return;
		}
		list.put(name, num);
	}
	static void delete(String name) {
		if(!list.containsKey(name)) {
			System.out.println("error");
			return;
		}
		list.remove(name);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String ans;
		String[] words;
		
		while(true) {
			ans = scn.nextLine();
			words = ans.split(" ");
			switch(words[0]) {
			case "show":
				show();
				break;
			case "find":
				if (words.length != 2) {
					System.out.println("error");
					break;
				}
				find(words[1]);
				break;
			case "add":
				if (words.length != 3) {
					System.out.println("error");
					break;
				}
				add(words[1], words[2]);
				break;
			case "delete":
				if (words.length != 2) {
					System.out.println("error");
					break;
				}
				delete(words[1]);
				break;
			default:
				System.out.println("error");
			}
		}
	}
}