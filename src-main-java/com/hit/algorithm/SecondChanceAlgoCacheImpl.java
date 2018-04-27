package com.hit.algorithm;

import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

//import javax.management.loading.PrivateClassLoader;

//Least Recently Used
public class SecondChanceAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V>{
	
	// Java collections
	//https://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html
	//https://www.geeksforgeeks.org/operating-system-page-replacement-algorithm/
	private HashMap<K, V> map; //first K is the Key, the K of the HashMap ()second Key is for counting reference
	private HashMap<K, Boolean> itemAccessPreviously;
	private Queue<K> queue;
	 
	//Constructor for the LRU Algorithm
	// The user can set the memory size
	public SecondChanceAlgoCacheImpl(int capacity)
	{
		super(capacity);
		this.map=new HashMap<>(capacity);
		this.itemAccessPreviously=new HashMap<>(capacity);
		this.queue = new LinkedList<K>();	

	}

	// Get the element at the K location
	@Override
	public V getElement(K key) {
		V value=null;
		if(map.containsKey(key))
			value=this.map.get(key);
		return value;
	}
		
	
	// Set the element at the K location with value V
	@Override
	public V putElement(K key, V value) {
		V removedVal=null;

		if(map.containsKey(key))
			this.itemAccessPreviously.put(key, true); 
		
		else if(!checkQueueCapacity(null)) {
			addItemToMemory(key,value,false);
		}
		
		else if(checkQueueCapacity(null))
		{
			for(K item : queue){				
				if(!itemAccessPreviously.get(item)) {
					queue.remove(item);
					map.remove(item);
					itemAccessPreviously.remove(item);
					break;
					}
				if(itemAccessPreviously.get(item)) {
					itemAccessPreviously.replace (item, false);
					}
				}
			
			addItemToMemory(key,value,false);
						
		}
		
	return removedVal;
	}
	
	private void addItemToMemory(K key, V value, boolean b) {
		queue.add(key);
		this.map.put(key, value);
		this.itemAccessPreviously.put(key, false);		
	}


	@Override
	public void removeElement(K key) {
			map.remove(key);
	}

	
	public boolean checkQueueCapacity(Entry<K, V> eldest) {
		return map.size()>=capacity;
	}
	
	
	
}