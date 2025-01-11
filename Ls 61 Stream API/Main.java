import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Remove duplicates and sort the list
        List<Integer> lst = Arrays.asList(3, 4, 5, 5, 4, 4, 3, 3, 5, 5, 2, 2, 1, 1);

        lst.stream().distinct().sorted().forEach((Integer i) -> {
            System.out.print(i + ", ");
        });

    }
}