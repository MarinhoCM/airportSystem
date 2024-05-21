import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void show(int[][] seats) {
        System.out.println("\t\tA\tB\tC\tD\tE\tF");
        for (int i = 0; i < 10; i++) {
            System.out.print("\nFILEIRA " + i + ":");
            for (int j = 0; j < 6; j++) {
                System.out.print("\t" + seats[i][j]);
            }
        }
    }

    public static void upSeats(int[][] seats, int row, int col) {
        seats[row][col] = 1;
        show(seats);

    }

    public static void main(String[] args) {
        int[][] seats = new int[10][6];
        Scanner input = new Scanner(System.in);
        show(seats);
        System.out.println("Escolha uma poltrona");
        String seat = input.nextLine();
        char[] row = seat.toCharArray();
        char[] collumns = {'A', 'B', 'C', 'D', 'E', 'F'};
        int sel_seat = Integer.parseInt(String.valueOf(row[0]));
        char col_char = row[1];
        int col = Arrays.binarySearch(collumns, col_char);
        System.out.println("O assento " + sel_seat + "Coluna " + col);
        upSeats(seats, sel_seat, col);
    }
}
