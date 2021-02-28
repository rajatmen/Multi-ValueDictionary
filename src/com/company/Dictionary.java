package com.company;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Dictionary<K, V> {

    /**
     * Returns all keys in the dictionary where order is not guaranteed.
     * @return returns all keys in dictionary
     */
    Set<K> getKeys();

    /**
     * Returns all associated values stored for given key. Return order is not guaranteed.
     * Displays error if value already exists
     * @param key the key with which the associated values will be returned
     * @return associated values stored for given key
     */
    Set<V> getMembers(K key);

    /**
     * Add a member to dictionary for given key. Displays errors if value already exists for given key.
     * @param key the key with which the associated values will be returned
     * @param value value to add to dictionary
     * @return boolean based on if adding to dictionary was a success or not
     */
    boolean add(K key, V value) throws Exception;

    /**
     * Remove a value from a key. If last value if removed from key, the key is removed from dictionary.
     * If the key or value does not exist, display error
     * @param key the key with which the associated value will be removed
     * @param value value to remove
     * @return boolean based on if removing of value was successful or not.
     */
    boolean remove(K key, V value) throws Exception;

    /**
     * Removes all values for a key and removes the key from the dictionary. Displays an error if key does not exist.
     * @param key the key with which the associated values will be returned
     * @return boolean based on if removing of all values for a key was successful or not.
     */
    boolean removeAll(K key) throws Exception;

    /**
     * Removes all keys and values from the dictionary.
     */
    void clear();

    /**
     * Returns whether a key exists or not.
     * @param key the key to check if it exists or not.
     * @return boolean based on if key exists in dictionary.
     */
    boolean keyExists(K key);

    /**
     * Returns whether a value exists within a key. Returns false if key does not exist
     * @param key the key to search for in dictionary.
     * @param value the value to search for in dictionary for given key.
     * @return boolean based on if value exists for given key.
     */
    boolean valueExists(K key, V value);

    /**
     * Returns all the values in the dictionary. Returns nothing if there are none. Order not guaranteed.
     * @return all values in dictionary
     */
    List<V> getAllMembers();

    /**
     * Returns all keys in the dictionary and all of their values.
     * Returns nothing if there are none.
     * Order is not guaranteed.
     * @return all keys and values in dictionary.
     */
    Map<K, Set<V>> getItems();

    /**
     * Returns String representation of dictionary.
     * @return String representation of dictionary.
     */
    String toString();
}
