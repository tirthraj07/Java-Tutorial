package com.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

// New Approach - 1
public class Example2 {
    public static final HashSet<Character> VOWELS = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public static void main(String[] args) {
        try(
                BufferedReader in = Files.newBufferedReader(Paths.get("verse.txt"));)
        {
            String line;
            int count = 0;
            while((line = in.readLine()) != null){
                for(char c: line.toCharArray()){
                    if(VOWELS.contains(c)){
                        count++;
                    }
                }
            }
            System.out.println("count = " + count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
