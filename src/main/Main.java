package main;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int choice;
        boolean running = true;
        Scanner scan = new Scanner(System.in);

        while (running) {
        System.out.println("[1]Add \t\t\t\t[2]Update \t\t[3]Search\n[4]Display all \t\t[5]exit");
        choice = scan.nextInt();
            if (choice  ==1 ) {

                /** add ticket */
                new ReservationTicket();
            }else if (choice == 2) {

                /** update ticket */
                System.out.println("update");
            }else if (choice == 3) {

                /** search ticket*/
                ReservationTicket.searchTicket();
                System.out.println("Search");
            }else if (choice == 4) {

                /** display all tickets*/
                ReservationTicket.displayReservationTickets();
            } else {
                running = false;
            }
        }
    }
}
