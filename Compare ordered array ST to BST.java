/*
Written by Rami Achkoudir, using the Java built-in functions HashMap and hashCode
Takes "A tale of two cities" as input and places each word into the hashmap using a hashcode
It prints out all the words and their corresponding hashvalue
 
 */

package labb3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class uppgift3 {
    public static void main(String[]args) throws FileNotFoundException{

    	//Create hashmap to store words
    	HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        
        Scanner text = new Scanner(new File("C:\\Users\\usr-ramach01\\Desktop\\test2.txt"));
        int totalwords = 0;
        int frequency = 0;
        //prime number used in addition to hashcode
        int m = 138883;
       
        //while function to go through all the words
        while (text.hasNext()){
            String word = text.next();
        
            //increment counter for equal keys
            if (hashmap.containsKey(word)){
                frequency++;     
            }
            /*
            put all words into the hashmap together with the hash value
            calculate hash value with Java's built in hashcode and make it a positive number
            before using mod together with the size of the map
             */
            hashmap.put(word, (word.hashCode() & 0x7fffffff) % m);
            System.out.println(word + " = " + hashmap.get(word));
            totalwords++;
        }
        text.close();
        
        
        //If the number of keys = unique words there are no collision
        if(totalwords - frequency == hashmap.size()) {
        	System.out.println("There are no collisions");
        }
        System.out.println("Total number of words = "+totalwords);
        System.out.println("Equal words = " + frequency);
        System.out.println("Keys in HashMap =  "+ hashmap.size());
        
    
    }
}