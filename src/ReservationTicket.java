import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ReservationTicket {

    /**
     * Store our object in ArrayList so that we can access it in future fetching
     */
    private static final ArrayList<ReservationTicket> reservationTickets = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    private int busNo;
    private int id = 1;
    private String nameOfPassenger;
    private String status;
    private String origin;
    private String destination;
    private int numOfSeats;
    private double fareRate;
    private String date;
    private double distance;


    /**
     * Constructor of our ticket
     */
    ReservationTicket(int id, int busNo, String nameOfPassenger, String origin, String destination, String date, int numOfSeats, String status, double fareRate, double distance) {
        this.id = id;
        this.busNo = busNo;
        this.nameOfPassenger = nameOfPassenger;
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.numOfSeats = numOfSeats;
        this.date = date;
        this.fareRate = fareRate;
        this.distance = distance;
    }


    ReservationTicket() {
    }

    /**
     * Get data from user input
     * ADD TICKET
     */
    public void addTicket(ArrayList<Bus> buses) {
        LocalDate localDate;
        setId();

        for (int i = 0; i < i+ 1; i++) {
            if (i == 0) {
                System.out.println("Enter bus Number: ");
                busNo = scan.nextInt();
                for (Bus bus : buses) {
                    if (bus.getBusNo() == busNo) {
                        i += 2;
                    } else {
                        i--;
                        System.out.println("Can't find bus number try again");
                    }
                    break;
                }
            }
            if (i == 2) {

                /** Input seat number*/
                System.out.println("Enter Seat");
                numOfSeats = scan.nextInt();
                scan.nextLine();

                /** Loop our bus arraylist to get the elements of bus capacity*/
                for (Bus b : buses) {

                    /** Check if inputted bus number is available in buses*/
                    if (b.getBusNo() == this.busNo) {

                        /** if bus seat number is equal to the inputted seat number then remove
                         *  the element in our arraylist seat number
                         * */
                        if (b.getCapacity().contains(this.numOfSeats)) {

                            /** the remove() predefined method is to remove the specific element in
                             *  our arraylist.
                             * */
                            b.getCapacity().remove((Integer) this.numOfSeats);
                            i += 2;
                        } else {
                            System.out.println("Seat is occupied, try another one");

                            /** decrement our i if the inputted seat number is not available in our arraylist
                             *  so that it will go back to ask a seat number.
                             * */
                            i--;
                        }
                        break;
                    }
                }
            }

            if (i == 4) {

                /** Input name of passenger*/
                System.out.println("Name: ");
                nameOfPassenger = scan.nextLine();

                /** Input status of passenger*/
                System.out.println("Status: ");
                status = scan.next();

                /** convert to lower case so that if the user will input some capital letters
                 * it will be converted to lower case and with that, we can check easily for our conditional
                 * statements.
                 * */
                status.toLowerCase();

                /** Set date*/
                System.out.println("Date: dd-mm-yyyy");
                String inputDate = scan.next();

                DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                localDate = LocalDate.parse(inputDate, formatDate);
                date = localDate.toString();

                System.out.println("Origin: ");
                origin = scan.next();
                System.out.println("Destination: ");
                destination = scan.next();
                System.out.println("Distance from Origin to Destination: ");
                distance = scan.nextDouble();

                /** call our setFareRate method to update our fare Rate */
                setFareRate();

                /** Create our object and add it in our array list so that we can access it in future*/
                reservationTickets.add(new ReservationTicket(id, busNo, nameOfPassenger, origin, destination, date, numOfSeats, status, fareRate, distance));
                break;

            }
        }
    }


    public void setNameOfPassenger(String nameOfPassenger) {
        this.nameOfPassenger = nameOfPassenger;
    }


    /**
     * The setter or our id
     */
    void setId() {
        for (ReservationTicket t : reservationTickets) {
            if (this.id == t.id) {
                this.id++;
            }
        }
    }

    /**
     * Set fare rate base on inputted distance
     */
    public void setFareRate() {
        final double succeedingKilometerForNotReg = 1.45;
        final double succeedingKilometerForReg = 1.85;
        final double minimumFareRateForReg = 11;
        final double minimumFareRateForNotReg = 8.75;
        double minimumDistance = 5;

        /** If passenger is  regular */
        if (status.equals("regular")) {
            if (this.distance <= 5) {
                this.fareRate = minimumFareRateForReg;
            } else {
                this.fareRate = ((distance - minimumDistance) * succeedingKilometerForReg) + minimumFareRateForReg;
            }

            /** If passenger is not regular */
        } else if (status.equals("pwd") || status.equals("student") || status.equals("senior citizen")) {
            if (this.distance <= 5) {
                this.fareRate = minimumFareRateForNotReg;
            } else {
                this.fareRate = ((distance - minimumDistance) * succeedingKilometerForNotReg) + minimumFareRateForNotReg;
            }
        }
    }


    /**
     * Search ticket
     */
    public void searchTicket() {

        for (int i = 0; i < i + 1; i++) {

            if (i == 1) {
                System.out.println("Your current id: ");
                int passengerId = scan.nextInt();
                scan.nextLine();
                System.out.println("Your current name: ");
                String passengerName = scan.nextLine();
                System.out.println("Bus No. : ");
                int passengerBusNo = scan.nextInt();
                scan.nextLine();
                /** Check if there is tickets added in our arraylist */
                if (reservationTickets.size() != 0) {

                    /** Loop our reservationTicket so that we get access to its elements*/
                    for (ReservationTicket reserves : reservationTickets) {

                        /** if ticket found then display*/
                        if (passengerId == reserves.id && Objects.equals(passengerName, reserves.nameOfPassenger) && passengerBusNo == reserves.busNo) {
                            System.out.println("\n\t\tFound Ticket!");
                            System.out.println("Name: " + reserves.nameOfPassenger);
                            System.out.println("Status: " + reserves.status);
                            System.out.println("Origin: " + reserves.origin);
                            System.out.println("Destination: " + reserves.destination);
                            System.out.println("Date : " + reserves.date);
                            System.out.println("Fare rate: " + reserves.fareRate + " \n");
                            i += 2;
                        } else {
                            System.out.println("Can't find ticket! try another one\n");
                            i--;
                        }
                        break;
                    }
                } else {
                    System.out.println("No ticket found, add one!\n");
                }


            }
        }

    }


    /**
     * Update ticket
     */
    public void updateTicket() {

        /** Call out searchTicket method to check if there's data */
        searchTicket();

        for (ReservationTicket reserves : reservationTickets) {

            System.out.println("Enter your new Name: ");
            String passengerNameToReplace = scan.nextLine();

            /** update passenger name*/
            reserves.setNameOfPassenger(passengerNameToReplace);

            System.out.println("\n\t\tTicket updated!");
            System.out.println("Name: " + reserves.nameOfPassenger);
            System.out.println("Status: " + reserves.status);
            System.out.println("Origin: " + reserves.origin);
            System.out.println("Destination: " + reserves.destination);
            System.out.println("Date : " + reserves.date);
            System.out.println("Fare rate: " + reserves.fareRate + " \n");
        }
    }


    /**
     * Display all  tickets
     */
    public void displayReservationTickets() {

        if (reservationTickets.size() == 0) {
            System.out.println("Sorry no Record Yet!");
        } else {
            System.out.format("+%-5s+%-20s+%-15s+%-15s+%-10s+%-10s+%-13s+%-10s+\n", "-----", "--------------------", "---------------", "---------------", "----------", "----------", "-------------", "----------");
            System.out.format("|%-5s|%-20s|%-15s|%-15s|%-10s|%-10s|%-13s|%-10s|\n", "Id", "Name", "Origin", "Destination", "Distance", "Status", "Date", "Fare Rate");
            System.out.format("+%-5s+%-20s+%-15s+%-15s+%-10s+%-10s+%-13s+%-10s+\n", "-----", "--------------------", "---------------", "---------------", "----------", "----------", "-------------", "----------");
            for (ReservationTicket t : reservationTickets) {
                System.out.format("|%-5d|%-20s|%-15s|%-15s|%-10s|%-10s|%-13s|%-10.2f|\n", t.id, t.nameOfPassenger, t.origin, t.destination, t.distance, t.status, t.date, t.fareRate);
            }
            System.out.format("+%-5s+%-20s+%-15s+%-15s+%-10s+%-10s+%-13s+%-10s+\n", "-----", "--------------------", "---------------", "---------------", "----------", "----------", "-------------", "----------");
        }
    }


}

