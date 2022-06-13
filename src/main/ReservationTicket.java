package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReservationTicket {
    private int busNo;
    private  int id =1;
    private final String nameOfPassenger;
    private final String status;
    private final String origin;
    private final String destination;
    private int  numOfSeats;
    private double fareRate;
    private final String date;
    private double distance;

    /** Constructor of our ticket*/
    ReservationTicket(int id, String nameOfPassenger, String origin, String destination, String date, int numOfSeats, String status, double fareRate, double distance) {
        this.id = id;
        this.nameOfPassenger = nameOfPassenger;
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.numOfSeats = numOfSeats;
        this.date = date;
        this.fareRate = fareRate;
        this.distance = distance;
    }

    /** Store our object in ArrayList so that we can access it in future fetching*/
    private static List<ReservationTicket> reservationTickets = new LinkedList<>();
    Scanner scan = new Scanner(System.in);

    /**Get data from user input */
    ReservationTicket() {
        final LocalDate localDate;
        System.out.println("Enter bus Number: ");
        busNo = scan.nextInt();
        setNumOfSeats();
        System.out.println("Name: ");
        nameOfPassenger = scan.nextLine();
        System.out.println("Status: ");
        status = scan.next();
        System.out.println("Origin: ");
        origin = scan.next();
        System.out.println("Destination: ");
        destination = scan.next();
        System.out.println("Date: dd-mm-yyyy");
        String inputDate = scan.next();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        localDate = LocalDate.parse(inputDate, formatDate);
        date = localDate.toString();
        reservationTickets.add(new ReservationTicket(id, nameOfPassenger, origin, destination, date, numOfSeats, status, fareRate, distance));
    }

    /** check if seat number is occupied*/
    public void setNumOfSeats() {
        ArrayList<Bus> bus = new Bus().getBus();
        for (int i = 0; i < 3; i++) {

            if (i == 1) {
                System.out.println("Enter Seat");
                numOfSeats = scan.nextInt();
                scan.nextLine();
                for (Bus b : bus) {
                    if (b.getBusNo() == this.busNo) {
                        if (b.getCapacity().contains(this.numOfSeats)) {
                            System.out.println(b.getCapacity());
                        }
                        ;
                    }
                }
            }
        }
    }


    /** The setter or our id  */
    void setId() {
        for (ReservationTicket t : reservationTickets) {
            if (this.id == t.id) {
                this.id++;
            }
        }
    }


    /** Setter of our Fare rate*/
    void setFareRate(double fareRate) {
        final double  discount = (fareRate / 10) * 2;
        if (status.equals("regular")){
         this.fareRate = fareRate * numOfSeats;
        } else if (status.equals("pwd") || status.equals("student") || status.equals("senior citizen")) {
            this.fareRate = (fareRate * numOfSeats ) - discount;
        }
    }

    /** Display all  tickets*/
    public static void displayReservationTickets() {

        if (reservationTickets.size() == 0) {
            System.out.println("Sorry no Record Yet!");
        } else {
            System.out.format("+%-5s+%-20s+%-15s+%-15s+%-10s+%-10s+%-13s+%-10s+\n", "-----", "--------------------","---------------"
                    ,"---------------","----------","----------","-------------","----------" );
            System.out.format("|%-5s|%-20s|%-15s|%-15s|%-10s|%-10s|%-13s|%-10s|\n","Id","Name", "Origin", "Destination", "Distance", "Status", "Date", "Fare Rate");
            System.out.format("+%-5s+%-20s+%-15s+%-15s+%-10s+%-10s+%-13s+%-10s+\n", "-----","--------------------","---------------","---------------",
                    "----------","----------","-------------","----------" );
            for (ReservationTicket t : reservationTickets) {
                System.out.format("|%-5d|%-20s|%-15s|%-15s|%-10s|%-10s|%-13s|%-10.2f|\n" ,t.id, t.nameOfPassenger , t.origin , t.destination, t.distance, t.status, t.date, t.fareRate);
            }
            System.out.format("+%-5s+%-20s+%-15s+%-15s+%-10s+%-10s+%-13s+%-10s+\n","-----", "--------------------","---------------","---------------","----------",
                    "----------","-------------" ,"----------");
        }
    }

    public static  void  searchTicket (){

    }


}
