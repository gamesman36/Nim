import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Heap heapA = new Heap(3);
        Heap heapB = new Heap(4);
        Heap heapC = new Heap(5);

        System.out.print("Player 1: ");
        String nameOfPlayer1 = scanner.nextLine();
        System.out.print("Player 2: ");
        String nameOfPlayer2 = scanner.nextLine();

        Player player1 = new Player(nameOfPlayer1);
        Player player2 = new Player(nameOfPlayer2);

        boolean gameIsOver = false;
        Player currentPlayer = player1;

        while (!gameIsOver) {
            System.out.println("Current state of heaps:");
            System.out.println("Heap A: " + heapA.GetNumOfObjects());
            System.out.println("Heap B: " + heapB.GetNumOfObjects());
            System.out.println("Heap C: " + heapC.GetNumOfObjects());

            System.out.println(currentPlayer.GetName() + ", choose a heap (A, B, or C) and the number of objects to remove:");
            String chosenHeap = scanner.next();
            int howMany = scanner.nextInt();

            Heap chosenHeapObject = null;
            if (chosenHeap.equalsIgnoreCase("A")) {
                chosenHeapObject = heapA;
            } else if (chosenHeap.equalsIgnoreCase("B")) {
                chosenHeapObject = heapB;
            } else if (chosenHeap.equalsIgnoreCase("C")) {
                chosenHeapObject = heapC;
            }

            if (chosenHeapObject != null && chosenHeapObject.RemoveObjects(howMany)) {
                if (heapA.GetNumOfObjects() == 0 && heapB.GetNumOfObjects() == 0 && heapC.GetNumOfObjects() == 0) {
                    System.out.println(currentPlayer.GetName() + " wins!");
                    gameIsOver = true;
                }
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }
}
