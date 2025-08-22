import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        System.out.println(" <<< Enter the string >>>");
        String text = str.nextLine().toLowerCase();
        System.out.println("Enter number (world(n)) : ");
        int number = str.nextInt();

        String[] words = text.split("\\s+");
        Map<String,Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word , counts.getOrDefault(word , 0) + 1);

        }

        System.out.println("Result : ");
        boolean find = false;
        for (  Map.Entry<String , Integer> fina : counts.entrySet()) {
            if(fina.getValue() == number) {
                find = true;
                System.out.println(fina.getKey());
            }
        }
        if( !find) {
            System.out.println("No word occurs  : "+ number );
        }
        str.close();

    }
}