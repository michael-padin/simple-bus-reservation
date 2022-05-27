package main;
import java.util.ArrayList;
import java.util.List;
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
                new ReservationTicket();
            }else if (choice == 2) {
                System.out.println("update");
            }else if (choice == 3) {
                System.out.println("Search");
            }else if (choice == 4) {
                ReservationTicket.displayReservationTickets();
            } else {
                running = false;
            }
        }
    }
}
