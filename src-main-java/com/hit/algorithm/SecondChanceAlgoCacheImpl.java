package com.hit.algorithm;

import java.util.HashMap;

public class SecondChanceAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V>{
    
	SecondChanceAlgoCacheImpl(int capacity) {
		super(capacity);
		this.valuesMap = new HashMap<>(capacity);
		// TODO Auto-generated constructor stub
	}

	private HashMap<K,V> valuesMap;
	private HashMap<K,Boolean> isDirtyMap;
	

	@Override
	public V getElement(K key) {
//		this.isDirtyMap.put(K, true);
//		return this.valuesMap.get(key);
		return null;
	}

	@Override
	public V putElement(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeElement(K key) {
//		this.isDirtyMap.remove(key);
//		this.valuesMap.remove(key);
//		return null;
	}
}


