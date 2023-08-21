import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Define the row sizes
        int[] rowSizes = {3, 2, 4, 1};
        // Get jagged array from user
        int[][] jaggedArray = getJaggedArray(rowSizes);
        // Display the jagged array
        displayJaggedArray(jaggedArray);
    }
    public static int[][] getJaggedArray(int[] rowSizes) {
        Scanner scanner = new Scanner(System.in);
        int[][] jaggedArray = new int[rowSizes.length][];

        for (int i = 0; i < rowSizes.length; i++) {
            System.out.print("Enter the number of elements for row " + (i + 1) + ": ");
            int numElements = scanner.nextInt();

            jaggedArray[i] = new int[numElements];

            for (int j = 0; j < numElements; j++) {
                System.out.print("Enter element " + (j + 1) + " for row " + (i + 1) + ": ");
                jaggedArray[i][j] = scanner.nextInt();
            }
        }
        return jaggedArray;
    }
    public static void displayJaggedArray(int[][] arr) {
        System.out.println("Jagged Array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Row " + (i + 1) + ": ");

            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
