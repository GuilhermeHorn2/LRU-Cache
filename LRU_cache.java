package misc;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU_cache<K,V>{
	
	// I will use a HashMap as base,because the order is not important,what is important is how recently this element was used
	
	public static class Item<K,V>{
		
		private V value;
		
		private K key;
		
		public Item(V value,K key) {
			this.value = value;
			this.key = key;
		}
			
		public V get_value() {
			return value;
		}
		
		public K get_key() {
			return key;
		}
	}
	
	private HashMap<K,Item> cache;
	private final int max_size;
	private int curr_size = 0;
	private LinkedList<Item> lru_queue;
	
	public LRU_cache(int max_size){
		cache = new HashMap<>();
		lru_queue = new LinkedList<>(); 
		this.max_size = max_size;
	}
	
	public V get_value(K key){
		
		//returns null if the value is not on the map
		
		if(!cache.containsKey(key)) {
			return null;
		}
		Item<K,V> i = cache.get(key);
		
		lru_queue.remove(i);
		lru_queue.addFirst(i);
		
		return i.get_value();
		
	}
	
	public void insert(K key,V value){
		
		//I will consider insertion as a usage
		Item<K,V> i = new Item(value,key);
		
		if(curr_size != max_size) {
			
			cache.put(key, i);
			lru_queue.addFirst(i);
			curr_size++;
			return;
		}
		
		Item<K,V> least = lru_queue.removeLast();
		cache.remove(least.get_key(), least);
		
		cache.put(key, i);
		lru_queue.addFirst(i);
		
		
	}
	
	public void show_items() {
		
		for(int i = 0;i < lru_queue.size();i++){
			
			System.out.println(lru_queue.get(i).get_value());
			
		}
		
	}
}
