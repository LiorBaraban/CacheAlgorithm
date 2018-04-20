package com.hit.algorithm;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

import com.hit.algorithm.IAlgoCache;
import com.hit.algorithm.LRUAlgoCacheImpl;
import com.hit.algorithm.MRUAlgoCacheImpl;
import com.hit.algorithm.RandomAlgoCacheImpl;

public class IAlgoCacheTest {

	private IAlgoCache<String, String> cache;
	private HashMap<String, String> clonedMap;
	int capacity = 5;
	String removedValue;

	@Test
	public void lruAlgoTest() {
		this.cache = new LRUAlgoCacheImpl<String, String>(this.capacity);
		// this.lruCache = new LRUAlgoCacheImpl<>(this.capacity);
		this.cache.putElement("a", "Alpha");
		this.cache.putElement("b", "Bravo");
		this.cache.putElement("c", "Charlie");
		this.cache.putElement("d", "Delta");
		this.cache.putElement("e", "Echo");
		this.cache.putElement("b", "Bravo");
		this.cache.putElement("f", "Foxtrot");
		this.cache.putElement("g", "Golf");
		Assert.assertEquals(null, this.cache.getElement("a"));
		Assert.assertEquals("Bravo", this.cache.getElement("b"));
		Assert.assertEquals(null, this.cache.getElement("c"));
		Assert.assertEquals("Delta", this.cache.getElement("d"));
		Assert.assertEquals("Echo", this.cache.getElement("e"));
		Assert.assertEquals("Foxtrot", this.cache.getElement("f"));
		Assert.assertEquals("Golf", this.cache.getElement("g"));
	}
	
    @Test
    public void mruAlgoTest(){
        this.cache = new MRUAlgoCacheImpl<>(this.capacity);
        this.cache.putElement("a","Alpha");
        this.cache.putElement("b","Bravo");
        this.cache.putElement("c","Charlie");
        this.cache.putElement("d","Delta");
        this.cache.putElement("e","Echo");
        this.cache.putElement("b","Bravo");
        this.cache.putElement("f","Foxtrot");
        this.cache.putElement("g","Golf");
        Assert.assertEquals("Alpha",this.cache.getElement("a"));
        Assert.assertEquals(null,this.cache.getElement("b"));
        Assert.assertEquals("Charlie",this.cache.getElement("c"));
        Assert.assertEquals("Delta",this.cache.getElement("d"));
        Assert.assertEquals("Echo",this.cache.getElement("e"));
        Assert.assertEquals(null,this.cache.getElement("f"));
        Assert.assertEquals("Golf",this.cache.getElement("g"));
    }
	
	@Test
	public void randomAlgoTest() {
		this.cache = new RandomAlgoCacheImpl<>(this.capacity);
		this.cache.putElement("a", "Alpha");
		this.cache.putElement("b", "Bravo");
		this.cache.putElement("c", "Charlie");
		this.cache.putElement("d", "Delta");
		this.cache.putElement("e", "Echo");
		this.clonedMap = ((RandomAlgoCacheImpl<String, String>) this.cache).cloneMap();
		this.removedValue = this.cache.putElement("f", "Foxtrot");
		System.out.println(this.removedValue);
		switch (this.removedValue) {
		case "Alpha":
			Assert.assertEquals("Alpha", this.clonedMap.get("a"));
			break;
		case "Bravo":
			Assert.assertEquals("Bravo", this.clonedMap.get("b"));
			break;
		case "Charlie":
			Assert.assertEquals("Charlie", this.clonedMap.get("c"));
			break;
		case "Delta":
			Assert.assertEquals("Delta", this.clonedMap.get("d"));
			break;
		case "Echo":
			Assert.assertEquals("Echo", this.clonedMap.get("e"));
			break;
		}
	}
	
}
