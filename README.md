# Multi-Value Dictionary Application
    - What is Multi-Value Dictionary?
        -Java command line application that stores a multivalue dictionary
          in memory. All keys and values are strings.
        -Supports the following commands (commands can be inputted in any case(lower/upper case)):
            - KEYS: returns all the keys in the dictionary. Order not guaranteed.
            - Members: Returns the collection of strings for the given key. Return order is not guaranteed. Returns an error if the key does not exists.
            - Add: Add a member to a collection for a given key. Displays an error if the value already existed in the collection.
            - Remove: Removes a value from a key. If the last value is removed from the key, they key is removed from the dictionary. If the key or value does not exist, displays an error.
            - RemoveAll: Removes all value for a key and removes the key from the dictionary. Returns an error if the key does not exist.
            - Clear: Removes all keys and all values from the dictionary.
            - KeyExists: Returns whether a key exists or not.
            - ValueExists: Returns whether a value exists within a key. Returns false if the key does not exist.
            - AllMembers: Returns all the values in the dictionary. Returns nothing if there are none. Order is not guaranteed
            - Items: Returns all keys in the dictionary and all of their values. Returns nothing if there are none. Order is not guaranteed
            - Help : Returns all the functions available for multi-value dictionary with method signatures

## System Requirements: 
    - Java 8 used to create application 
##Steps to build and run Multi-Value Dictionary command line application:
    - Clone repo
    - Navigate to src/com/company directory
    - Use javac command to compile java project (example below):
        - javac -d . .\Main.java .\MultiValueDict.java .\Constants.java .\AbstractDictionary.java .\Dictionary.java  
    - Run application in correct package using: 
        - java com.company.Main