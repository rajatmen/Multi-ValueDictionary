package com.company;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    /**
     * Main method that runs program. Uses a scanner to take input from user.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Multi-Value Dictionary App. " +
                "Please enter command or enter HELP for more information");

        MultiValueDict<String, String> multiValueDict = new MultiValueDict<>();

        Scanner scanner = new Scanner(System.in);

            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String [] inputArr = input.split(Constants.EMPTY_SPACE);

                if(inputArr[0].equalsIgnoreCase(Constants.EXIT)) {
                    scanner.close();
                    break;
                } else {
                    try {
                        processInput(inputArr, multiValueDict);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
    }

    /**
     * Method used to process command line input and perform, correct function on multi-value dictionary
     * @param input input command passed in from command line
     * @param multiValueDict - multi-value dictionary on which functions will be performed.
     * @throws Exception throws exception when bad input or if key/value does not exist.
     */
    private static void processInput(String[] input, MultiValueDict<String, String> multiValueDict) throws Exception {
        if(input[0].equalsIgnoreCase(Constants.HELP)) {
            printHelpMessage();
        } else if(input.length == 3 && input[0].equalsIgnoreCase(Constants.ADD)) {
            multiValueDict.add(input[1], input[2]);
        } else if(input[0].equalsIgnoreCase(Constants.KEYS)) {
            printCollection(multiValueDict.getKeys());
        } else if(input.length == 2 && input[0].equalsIgnoreCase(Constants.MEMBERS)) {
            if(multiValueDict.keyExists(input[1])) {
                printCollection(multiValueDict.getMembers(input[1]));
            } else {
                throw new Exception("ERROR, key does not exist");
            }
        } else if(input.length >= 2 && input[0].equalsIgnoreCase(Constants.REMOVE)) {
            if(input.length < 3) {
                multiValueDict.removeAll(input[1]);
            } else {
                multiValueDict.remove(input[1], input[2]);
            }
        } else if(input.length == 2 && input[0].equalsIgnoreCase(Constants.REMOVEALL)) {
            multiValueDict.removeAll(input[1]);
        } else if(input[0].equalsIgnoreCase(Constants.CLEAR)) {
            multiValueDict.clear();
            System.out.println("Cleared Dictionary");
        } else if(input.length == 2 && input[0].equalsIgnoreCase(Constants.KEYEXISTS)) {
            System.out.println(multiValueDict.keyExists(input[1]));
        } else if(input.length == 3 && input[0].equalsIgnoreCase(Constants.VALUEEXISTS)) {
            System.out.println(multiValueDict.valueExists(input[1], input[2]));
        } else if(input[0].equalsIgnoreCase(Constants.ALLMEMBERS)) {
            printCollection(multiValueDict.getAllMembers());
        } else if(input[0].equalsIgnoreCase(Constants.ITEMS)) {
            System.out.print(multiValueDict.toString());
        } else {
            //bad input
            throw new Exception("Error occured. Please ensure that you are entering method/data correctly." +
                    " Type help for method signatures");
        }
    }

    /**
     * Helper function to log out method signatures from Dictionary interface.
     * Uses reflection to get the method names and parameter types
     */
    private static void printHelpMessage() {
        try {
            StringBuilder sb = new StringBuilder();
            Class<?> dictionaryClass = Class.forName("com.company.Dictionary");
            Method[] methods = dictionaryClass.getDeclaredMethods();

            for(Method method : methods) {

                if(!method.getName().equalsIgnoreCase("toString")) {

                    Parameter[] parameters = method.getParameters();
                    StringBuilder p = new StringBuilder();

                    for(Parameter parameter : parameters) {
                        p.append(parameter.getParameterizedType().getTypeName())
                                .append(" ").append(parameter.getName()).append(", ");
                    }

                    if(p.length() >= 2) {
                        p.setLength(p.length() - 2);
                    }

                    sb.append("Method name: ").append(method.getName().toUpperCase()).append(" and method signature:  ")
                            .append(method.getName()).append("(").append(p.toString()).append(");\n");
                }
            }

            System.out.print(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Helper method to print collections (sets/lists) when needed for certain functions
     */
    private static void printCollection(Collection<String> collection) {
        StringBuilder sb = new StringBuilder();

        int number = 1;
        for(String value : collection) {
            sb.append(number + ") " + value + "\n");
            number++;
        }

        System.out.print(sb.toString().length() > 0 ? sb.toString() : "Empty Set \n");
    }
}
