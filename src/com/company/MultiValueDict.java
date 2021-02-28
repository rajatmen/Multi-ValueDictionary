package com.company;

import java.util.*;

public class MultiValueDict<K, V> extends AbstractDictionary<K, V> {

    //constructor to initialize dictionary
    public MultiValueDict() {
        dictionary = new HashMap<>();
    }

    public boolean add(K key, V value) throws Exception {

        Set<V> set = this.getMembers(key);

        if(set != null) {
            //key exists in dictionary map, add value to map
            if(set.contains(value)) {
                //return false so we know that value exists already and add was not successful
                throw new Exception("ERROR, value: " + value + " already exists for key: "+ key);
            }

            //add value to existing set
            set.add(value);
        } else {
            //key does not exist, put new set with key in dictionary map
            set = new HashSet<>();
            set.add(value);
            this.dictionary.put(key, set);
        }

        //if we make it down this far, add was successful
        System.out.println("Added");
        return true;
    }

    public boolean remove(K key, V value) throws Exception {

        Set<V> set = this.getMembers(key);

        if(set != null) {
            //key exists in dictionary map. check to see if value exists. if it does remove it
            if(set.contains(value)) {
                if(set.size() <= 1) {
                    this.dictionary.remove(key);
                } else {
                    set.remove(value);
                }
                System.out.println("Removed, value: " + value + " for key: "+ key);
                return true;
            } else {
                throw new Exception("ERROR, value: " + value + " does not exist for key: " + key);
            }
        } else {
            throw new Exception("ERROR, key: does not exist");
        }
    }

    public boolean removeAll(K key) throws Exception {

        if(!keyExists(key)) {
            throw new Exception("ERROR, key does not exist");
        }

        System.out.println("REMOVED values for key: " + key);
        return this.dictionary.remove(key) != null;
    }

    public boolean valueExists(K key, V value) {
        Set<V> set = this.getMembers(key);

        return set != null && set.contains(value);
    }

    public List<V> getAllMembers() {
        List<V> allMembers = new ArrayList<>();

        for(K key : this.getKeys()) {
            allMembers.addAll(this.getMembers(key));
        }

        //returns empty list if dictionary is empty
        return allMembers;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        int number = 1;
        for(K key : this.getKeys()) {
            for(V value : this.getMembers(key)) {
                sb.append(number + ") " + key + ": " + value + "\n");
                number++;
            }
        }

        return sb.toString().length() > 0 ? sb.toString() : "Empty Dictionary \n";
    }

}
