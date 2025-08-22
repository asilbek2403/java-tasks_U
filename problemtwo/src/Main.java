import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sorted integers separated by (space) array: ");
        String[] inArr = sc.nextLine().split("\\s+");
        int[] arr = new int[inArr.length];
        for (int i = 0 ; i < inArr.length ; i++) {
            arr[i] = Integer.parseInt(inArr[i]);
        }
        System.out.println("Enter target summa : ");
        int targetSum = sc.nextInt();

        int l=0;
        int r=arr.length-1;
        boolean findR = false;
        System.out.println("Pairs with sum = " + targetSum + ":");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + targetSum);
                    findR = true;
                }
            }
        }
        if ( !findR) {
            System.out.println("No two numbers sum to" +targetSum);
        }

        sc.close();
    }
}
