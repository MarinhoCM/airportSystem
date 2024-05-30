
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    protected static Scanner sc = new Scanner(System.in);

    public static int TicketsMenu() {
        System.out.println("\n<------------------------- Olá! Bem Vindo ----------------------->");
        System.out.println("Escolha seu tipo de passagem: ");
        System.out.println("1 - Bilhete Normal");
        System.out.println("2 - Bilhete Promocional");
        System.out.print("---->  ");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static void ShowSeats(int[][] seats) {
        System.out.println(" ");
        System.out.println("\t\tA\tB\tC\tD\tE\tF");
        for (int i = 0; i < 10; i++) {
            System.out.print("\nFILEIRA " + i + ":");
            for (int j = 0; j < 6; j++) {
                System.out.print("\t" + seats[i][j]);
            }
        }
        System.out.println();
    }

    public static void upSeats(int[][] seats, int row, int col) {
        seats[row][col] = 1;
        ShowSeats(seats);
    }

    public static void main(String[] args) {
        int[][] seats = new int[10][6];
        char[] columns = {'A', 'B', 'C', 'D', 'E', 'F'};
        String loopControl;
        int TicketOption = TicketsMenu();

        ShowSeats(seats);
        if (TicketOption == 1) {
            do {
                System.out.print("\nEscolha uma poltrona (ex: 4B): ");
                String seat = sc.nextLine();
                char[] row = seat.toCharArray();
                int sel_seat = Character.getNumericValue(row[0]);
                char col_char = row[1];
                int col = Arrays.binarySearch(columns, col_char);
                System.out.println("O assento " + sel_seat + " | Coluna " + col_char);
                upSeats(seats, sel_seat, col);
                System.out.print("\nDeseja selecionar mais uma poltrona? [s/n]: ");
                loopControl = sc.nextLine();
            } while (loopControl.equalsIgnoreCase("s"));
        } else {
            System.out.print("\nDigite a quantidade de bilhetes que deseja: ");
            int tickets = sc.nextInt();
            sc.nextLine();

            int initial_row = 2;
            int initial_col = 2;
            int seats_allocated = 0;

            while (seats_allocated < tickets) {
                if (initial_col >= 6) {
                    initial_row++;
                    initial_col = 0;
                    if (initial_row >= 10) {
                        System.out.println("Não há poltronas suficientes disponíveis.");
                        break;
                    }
                }

                if (initial_col == 0 || initial_col == 5) {
                    initial_col++;
                    continue;
                }

                if (seats[initial_row][initial_col] == 0) {
                    seats[initial_row][initial_col] = 1;
                    seats_allocated++;
                }
                initial_col++;
            }
            ShowSeats(seats);
        }
    }
}
