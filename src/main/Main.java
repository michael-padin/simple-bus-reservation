package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice;
        boolean running = true;
        Scanner scan = new Scanner(System.in);

        /** store our Object in arraylist */
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Integer> capacity = new ArrayList<>();

        /** add bus capacity */
        for (int i = 1; i <= 2; i++) {
            capacity.add(i);
        }
        /** add our object bus to our array list */
        buses.add(new Bus(101, "Ceres1", "csbt", "samboan", capacity));

        while (running) {
            ReservationTicket ticket = new ReservationTicket();
            System.out.println("[1]Add \t\t\t\t[2]Update \t\t[3]Search\n[4]Display all \t\t[5]exit");
            choice = scan.nextInt();
            if (choice == 1) {

                /** display our bus info*/
                  new Bus().displayBus(buses);

                /** add ticket */
                ticket.addTicket(buses);
            } else if (choice == 2) {

                /** update ticket */
                ticket.updateTicket();;
            } else if (choice == 3) {

                /** search ticket*/
                ticket.searchTicket();
            } else if (choice == 4) {

                /** display all tickets*/
                ticket.displayReservationTickets();
            } else {
                running = false;
            }
        }
    }
}
