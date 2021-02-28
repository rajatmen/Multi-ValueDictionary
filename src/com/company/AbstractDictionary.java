package com.company;

import java.util.Map;
import java.util.Set;

public abstract class AbstractDictionary <K,V> implements Dictionary <K,V> {

    protected Map<K, Set<V>> dictionary;

    public Set<K> getKeys() {return dictionary.keySet();}

    public Set<V> getMembers(K key) {return dictionary.get(key);}

    public void clear() {
        dictionary.clear();
    }

    public boolean keyExists(K key) {return dictionary.containsKey(key);}

    public Map<K, Set<V>> getItems() {return dictionary;}
}
