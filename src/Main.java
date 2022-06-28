import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        Scanner scan = new Scanner(System.in);

        /** bus arraylist */
        ArrayList<Bus> buses = new ArrayList<>();

        /** capacity of each bus */
        ArrayList<Integer> capacity = new ArrayList<>(); // 1..38
        ArrayList<Integer> capacity2 = new ArrayList<>(); // 1..38

        /** add bus capacity */
        for (int i = 1; i <= 2; i++) {
            capacity.add(i);
            capacity2.add(i);
        }

        /**
         * @csbt = cebu south bus terminal
         * create our object "Bus" and then add it our arraylist
         */
        buses.add(new Bus(101, "Ceres01", "csbt", "samboan", capacity));
        buses.add(new Bus(102, "Ceres02", "csbt", "barili", capacity2));


        for (int i = 0; i < 5; i++) {

            /** instantiate our reservation tickets  so that we can access the methods there.*/
            ReservationTicket ticket = new ReservationTicket();

            System.out.println("\n\n[1]Add \t\t\t\t[2]Update \t\t[3]Search\n[4]Display all \t\t[5]exit\n\n");

            /** Enter choice for specific actions */
            if (i == 0) {
                System.out.print("Choice: ");
                choice = scan.nextInt();
            }

            if (choice == 1) {

                /** display our bus info*/
                new Bus().displayBus(buses);

                /** add ticket */
                ticket.addTicket(buses);
                i--;
            } else if (choice == 2) {

                /** search ticket*/
                ticket.searchTicket();
                i--;
            } else if (choice == 3) {
                /** update ticket */
                ticket.updateTicket();
                i--;
            } else if (choice == 4) {

                /** display all tickets*/
                ticket.displayReservationTickets();
                i--;
            } else if (choice == 5) {

                /** exit */
                i = 5;
            } else {
                System.out.println("Enter valid number!!");
                i = -1;
            }
        }
    }
}
