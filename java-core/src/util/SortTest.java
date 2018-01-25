package util;

import java.util.TreeSet;

public class SortTest {
	
	public static void main(String[] args) {
		
		String[] tms = {"2017-12", "2017-05", "2017-08", "2017-10", "2017-01"};
		TreeSet<String> set = new TreeSet<String>();
		
		for(String s : tms){
			set.add(s);
		}
		
		System.out.println(set);
	}
	
}
