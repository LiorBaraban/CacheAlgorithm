package com.hit.algorithm;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MRUAlgoCacheImpl<K, V> extends AbstractAlgoCache<K, V> {
    private LinkedHashMap<K, V> map;

    public MRUAlgoCacheImpl(int capacity) {
        super(capacity);
        this.map = new LinkedHashMap<K, V>();
    }

    @Override
    public V getElement(K key) {
        return this.map.get(key);
    }

    @Override
    public V putElement(K key, V value) {
        V removedValue = null;

        if (this.map.containsKey(key)) {
            this.map.remove(key);
        }
        else if (this.map.size() >= this.capacity) {
            Iterator<K> mapIterator = this.map.keySet().iterator();
            K removedKey = null;
            while (mapIterator.hasNext()) {
                removedKey = mapIterator.next();
            }
            removedValue = this.extractValueFromMap(removedKey);
        }
        this.map.put(key, value);
        return removedValue;
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

}
