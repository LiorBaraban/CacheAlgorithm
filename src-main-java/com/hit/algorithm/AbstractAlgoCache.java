package com.hit.algorithm;
public abstract class AbstractAlgoCache<K,V> implements IAlgoCache<K,V>{

    public int capacity; //not sure about this

    AbstractAlgoCache(int capacity){
        this.capacity = capacity;   //not sure about this
    }

    @Override
    public abstract V getElement(K key);

    @Override
    public abstract V putElement(K key, V value);

    @Override
    public abstract void removeElement(K key);
}
