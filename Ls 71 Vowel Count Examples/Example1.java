// Refer: https://www.youtube.com/live/Jg-4XYOQmeM?si=SYY9jsHVebaaFHUN
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

// Legacy (OLD) Approach
// Count Vowels Code
public class Example1 {
    public static final HashSet<Character> VOWELS = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public static void main(String[] args) {
        try(
                FileInputStream fis = new FileInputStream("verse.txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader in = new BufferedReader(isr);)
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
            throw new RuntimeException(e);
        }

    }
}
