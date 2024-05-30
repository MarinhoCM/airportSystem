
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    protected static Scanner sc = new Scanner(System.in);

    public static int TicketsMenu() {
        System.out.println("\n<------------------------- Olá! Bem Vindo ----------------------->");
        System.out.println("Escolha seu tipo de passagem: ");
        System.out.println("1 - Bilhete Promocional");
        System.out.println("2 - Bilhete Normal");
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
    }

    public static void upSeats(int[][] seats, int row, int col) {
        seats[row][col] = 1;
        ShowSeats(seats);
    }

    public static void main(String[] args) {
        int[][] seats = new int[10][6];
        char[] collumns = {'A', 'B', 'C', 'D', 'E', 'F'};
        String loopControl;
        int TicketOption = TicketsMenu();

        ShowSeats(seats);
        if (TicketOption == 1) {
            do {
                System.out.print("\nEscolha uma poltrona: ");
                String seat = sc.nextLine();
                char[] row = seat.toCharArray();
                int sel_seat = Integer.parseInt(String.valueOf(row[0]));
                char col_char = row[1];
                int col = Arrays.binarySearch(collumns, col_char);
                System.out.println("O assento " + sel_seat + " | Coluna " + col);
                upSeats(seats, sel_seat, col);
                System.out.print("\nDeseja selecionar mais uma poltrona? [s/n]: ");
                loopControl = sc.nextLine();
            } while (loopControl.equalsIgnoreCase("s"));
        } else {
            // poltronas do meio: C D - 2 A 7
            System.out.print("\nDigite a quantidade de bilhetes que deseja: ");
            int tickets = sc.nextInt();
            int initial_row = 4;
            int initial_col = 2;
            for (int i = 1; i < tickets; i++) {
                if (!(i >=  2))
                    seats[initial_row][initial_col + i] = 1;
                else
                    seats[initial_row][initial_col + i] = 1;
            }
            ShowSeats(seats);
            // 3.Caso seja do tipo promocional, o sistema escolhe as poltronas automaticamente(prioridade poltronas do centro).
            // 4.Caso sejam compradas mais de um passagem, a prioridade é coloca-los alinhados na mesma fila.
            // 5.Caso o voo do usuário tenha conexão, a prioridade são as poltronas da frente.
        }
    }
}
