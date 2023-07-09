package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main_misc {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LRU_cache<Integer,String> cache = new LRU_cache<>(5);
		cache.insert(0, "a");
		cache.insert(1, "b");
		cache.insert(2, "c");
		cache.insert(3, "d");
		cache.insert(4, "e");
		cache.show_items();
		cache.get_value(0);
		System.out.println("------");
		cache.show_items();
		cache.insert(5, "f");
		System.out.println("------");
		cache.show_items();
	

	}
	
	
	
	

}
