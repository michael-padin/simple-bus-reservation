import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int choice = 0;

        /* bus arraylist */
        ArrayList<Bus> buses = new ArrayList<>();

        /* capacity of each bus */
        ArrayList<Integer> capacity = new ArrayList<>(); // 1..38
        ArrayList<Integer> capacity2 = new ArrayList<>(); // 1..38
        ArrayList<Integer> capacity3 = new ArrayList<>(); // 1..38

        /* add the numbers as elements of our bus capacity arrayList */
        for (int i = 1; i <= 38; i++) {
            capacity.add(i);
            capacity2.add(i);
            capacity3.add(i);
        }

        /*
         * csbt = cebu south bus terminal
         * create our object "Bus" and then add it our arraylist
         */
        buses.add(new Bus(101, "Ceres01", "csbt", "samboan", capacity));
        buses.add(new Bus(102, "Ceres02", "csbt", "barili", capacity2));
        buses.add(new Bus(103, "Ceres03", "csbt", "naga", capacity3));

        /* instantiate our reservation tickets  so that we can access the methods of the class.*/
        ReservationTicket ticket = new ReservationTicket();

        while (true) {
//            display choices
            System.out.println("\n\n\t\t\t  BUS RESERVATION SYSTEM\n");
            System.out.println("[1]Add \t\t\t\t[2]Search \t\t[3]Update\n[4]Display all \t\t[5]exit\n\n");

            /* Enter choice for specific actions */
            System.out.print("Choice: ");
            choice = scan.nextInt();

            if (choice == 1) {
                /* display our bus info*/   
                new Bus().displayBus(buses);

                /* add ticket */
                ticket.addTicket(buses);

            } else if (choice == 2) {

                /* search ticket*/
                ticket.searchTicket();

            } else if (choice == 3) {
                /* update ticket */
                ticket.updateTicket();

            } else if (choice == 4) {
                /* display all tickets*/
                ticket.displayReservationTickets();

            } else if (choice == 5) {
                /* exit */
                break;

            } else {
                System.out.println("Enter valid number!!");
            }
        }
    }
}
