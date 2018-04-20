package com.hit.algorithm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class RandomAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V>{

    private HashMap<K,V> map;

    public RandomAlgoCacheImpl(int capacity) {
        super(capacity);
        this.map = new HashMap<>();
    }

    @Override
    public V getElement(K key) {
        return this.map.get(key);
    }

    @SuppressWarnings("unchecked")
	@Override
    public V putElement(K key, V value) {
        V removedValue = null;
        if(this.map.containsKey(key)){
            this.map.remove(key);
        }
        else if (this.map.size()>=this.capacity){
            Random rand = new Random();
//            Set<K> set = this.map.keySet();
//            ArrayList<K> arrayOfMapKeys = new ArrayList<>();
//            for (Iterator<K> i = set.iterator(); i.hasNext();) {           	
//            	K item = set.iterator().next();
//            	arrayOfMapKeys.add(item);
//            }
            
            
            Object[] objectKeysArray = this.map.keySet().toArray();
            ArrayList<K> keysArrayList = new ArrayList<>();
            for(int i=0; i< objectKeysArray.length;i++) {
            	keysArrayList.add((K)objectKeysArray[i]);
            }
            K removedKey = keysArrayList.get(rand.nextInt(keysArrayList.size()));
            removedValue = this.extractValueFromMap(removedKey);
        }
        this.map.put(key,value);
        return  removedValue;
    }

    private V extractValueFromMap(K removedKey) {
        V element = this.getElement(removedKey);
        this.removeElement(removedKey);
        return element;
    }

    @Override
    public void removeElement(K key) {
        this.map.remove(key);

    }
    
    public HashMap<K,V> cloneMap(){
    	HashMap<K,V> clonedMap = new HashMap<>();
    	for(Iterator<K> i = this.map.keySet().iterator();i.hasNext();) {
    		K key = i.next();
    		V value = this.map.get(key);
    		clonedMap.put(key, value);
    	}
    	return clonedMap;
    }
    
}
