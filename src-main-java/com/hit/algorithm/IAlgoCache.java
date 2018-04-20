package com.hit.algorithm;
public interface IAlgoCache<K,V>{

	//Returns the value to which the specified key is mapped,
    // or null if this cache contains no mapping for the key.
    // In addition performs the relevant cache algorithm
    //Parameters:
    //key - with which the specified value is to be associated
    //Returns:
    //the value to which the specified key is mapped, or null if this cache contains no mapping for the key
    public V getElement(K key);


    //Associates the specified value with the specified key in this cache according to the current algorithm
    //Parameters:
    //key - with which the specified value is to be associated
    //value - to be associated with the specified key
    //Returns:
    //return the value of the element which need to be replaced
    public V putElement(K key, V value);

    //Removes the mapping for the specified key from this map if present.
    //Parameters:
    //key - whose mapping is to be removed from the cache according to the current algorithm
    public void removeElement(K key);
}
