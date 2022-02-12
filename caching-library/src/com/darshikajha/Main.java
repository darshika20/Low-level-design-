package com.darshikajha;

import com.darshikajha.Factory.CacheFactory;
import com.darshikajha.cache.Cache;
import com.darshikajha.exceptions.InvalidElementException;
import com.darshikajha.exceptions.StorageFullException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CacheFactory cacheFactory = new CacheFactory();
        Cache cache = cacheFactory.getDefaultCache();
        System.out.println("Put 1 to 6 nos in cache and then get the first entry from cache");
        try {
            cache.put("1","one");
            cache.put("2","two");
            cache.put("3","three");
            cache.put("4","four");
            cache.put("5","five");
            cache.put("6","six");

        } catch (StorageFullException e) {
            e.printStackTrace();
        }
        System.out.println("Reached here");

        try {
            System.out.println("Get 6 from cache : " +cache.get("6"));
            System.out.println("Get 1 from cache : " +cache.get("1"));

        } catch (InvalidElementException e) {
            e.printStackTrace();
        }
    }
}
