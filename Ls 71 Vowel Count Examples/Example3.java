package com.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Example3 {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) throws Exception {
        Path filePath = Paths.get("verse.txt");
        long count = Files.lines(filePath)
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .filter(vowels::contains)
                .count();
        System.out.println("count = " + count);
    }
}
