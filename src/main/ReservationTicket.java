package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReservationTicket {
    private String nameOfPassenger;
    private String origin;
    private String destination;
    private double fareRate;
    private LocalDate date;
    private String inputDate;
    private String status;
    private double distance;

    ReservationTicket(String nameOfPassenger, String origin, String destination, LocalDate date, String status, double fareRate, double distance) {
        this.nameOfPassenger = nameOfPassenger;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.status = status;
        this.fareRate = fareRate;
        this.distance = distance;
    }

    private static List<ReservationTicket> reservationTickets = new LinkedList<>();
    Scanner scan = new Scanner(System.in);

    ReservationTicket() {
        System.out.println("Name: ");
        nameOfPassenger = scan.nextLine();
        System.out.println("Status: ");
        status = scan.next();
        System.out.println("Origin: ");
        origin = scan.next();
        System.out.println("Destination: ");
        destination = scan.next();
        System.out.println("Data: dd-mm-yy");
        inputDate = scan.next();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        date = LocalDate.parse(inputDate, formatDate);
        setDistance();
        setFareRate();
        reservationTickets.add(new ReservationTicket(nameOfPassenger, origin, destination, date, status, fareRate, distance));
    }

     void setDistance() {
        destination.toLowerCase();
        origin.toLowerCase();
        if (destination.equals("samboan") && origin.equals("csbt")||origin.equals("samboan") && destination.equals("csbt")){
        distance = 148.6;
        }
    }

     void setFareRate() {
        status.toLowerCase();
        if (status.equals("regular")){
         fareRate = 350;
        } else if (status.equals("pwd") || status.equals("student") || status.equals("senior citizen")) {
            fareRate = 350 - ((350 / 10) * 2) ;

        }
    }


    public static void displayReservationTickets() {
        Formatter fmt = new Formatter();
        if (reservationTickets.size() == 0) {
            System.out.println("Sorry no Record Yet!");
        } else {
            System.out.printf("+%-20s+%-15s+%-15s+%-10s+%-10s+%-10s+\n", "--------------------","---------------","---------------","----------","----------","----------" );
            System.out.printf("|%-20s|%-15s|%-15s|%-10s|%-10s|%-10s|\n","Name", "Origin", "Destination", "Distance", "Status", "Fare Rate");
            System.out.printf("+%-20s+%-15s+%-15s+%-10s+%-10s+%-10s+\n", "--------------------","---------------","---------------","----------","----------","----------" );
            for (ReservationTicket t : reservationTickets) {
                System.out.printf("|%-20s|%-15s|%-15s|%-10s|%-10s|%-10.2f|\n" , t.nameOfPassenger , t.origin , t.destination, t.distance, t.status, t.fareRate);
            }
            System.out.printf("+%-20s+%-15s+%-15s+%-10s+%-10s+%-10s+\n", "--------------------","---------------","---------------","----------","----------","----------" );
        }
    }


}
