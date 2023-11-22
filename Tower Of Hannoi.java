import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numberOfDisks = scanner.nextInt();

        System.out.println("\nSteps to solve the Tower of Hanoi with " + numberOfDisks + " disks:");
        solveTowerOfHanoi(numberOfDisks, 'A', 'B', 'C');

        scanner.close();
    }

    private static void solveTowerOfHanoi(int disks, char source, char auxiliary, char destination) {
        if (disks == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        solveTowerOfHanoi(disks - 1, source, destination, auxiliary);
        System.out.println("Move disk " + disks + " from " + source + " to " + destination);
        solveTowerOfHanoi(disks - 1, auxiliary, source, destination);
    }
}
