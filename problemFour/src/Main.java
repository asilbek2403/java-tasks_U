import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");

        int tamano = sc.nextInt();
        int[] numer = new int[tamano];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < tamano; i++) {
            numer[i] = sc.nextInt();
        }
        int longit = eliDuplicat(numer);
        int[] result = Arrays.copyOf(numer, longit);
        System.out.println("Result: " + Arrays.toString(result));
    }


    public static int eliDuplicat(int[] numer) {
        if (numer.length == 0)
            return 0;

        int j = 0;
        for (int i = 1; i < numer.length; i++) {
            if (numer[i] != numer[j]) {
                j++;
                numer[j] = numer[i];
            }
        }
        return j + 1;
    }

}