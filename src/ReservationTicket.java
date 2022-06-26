import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ReservationTicket {
    /**
     * Store our object in ArrayList so that we can
     * access it later
     */
    private static final ArrayList<ReservationTicket> reservationTickets = new ArrayList<>();
    static boolean isError;
    Scanner scan = new Scanner(System.in);

    /**
     * attributes of our className
     */
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

        for (int i = 0; i < 7; i++) {

            if (i == 0) {
                System.out.print("Enter bus Number: ");
                this.busNo = scan.nextInt();

                for (Bus bus : buses) {
                    /** if ang gi input sa user is equals sa bus number then proceed*/
                    if (this.busNo == bus.getBusNo()) {
                        System.out.println("\nAvailable seats: " + bus.getCapacity().toString());
                        i = 2;

                    } else {
                        i--;
                    }

                    if (bus.getCapacity().size() == 0) {
                        System.out.println("Bus is full! try other bus or try again next time");
                        i = 7;
                    }
                }
            }
            if (i == 2) {

                /** Input seat number*/
                System.out.print("Enter Seat: ");
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
                System.out.print("Name: ");
                nameOfPassenger = scan.nextLine();

                /** Input status of passenger*/
                System.out.println("Status: [regular, pwd, senior, student]");
                status = scan.next();

                /** convert to lower case so that if the user will input some capital letters
                 * it will be converted to lower case and with that, we can check easily in future
                 * */
                status.toLowerCase();

                /** Set date*/
                System.out.print("Date: dd-mm-yyyy: ");
                String inputDate = scan.next();

                /** format date using date formatter*/
                DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                localDate = LocalDate.parse(inputDate, formatDate);
                this.date = localDate.toString();


                System.out.print("Origin: ");
                this.origin = scan.next();
                System.out.print("Destination: ");
                this.destination = scan.next();
                System.out.print("Distance from Origin to Destination: ");
                this.distance = scan.nextDouble();

                /** call our setFareRate method to update our fare Rate */
                setFareRate();

                /** Create our object and add it in our array list so that we can access it in future*/
                reservationTickets.add(new ReservationTicket(id, busNo, nameOfPassenger, origin, destination, date, numOfSeats, status, fareRate, distance));
                System.out.println("\n\nTicket added...");
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
            /** ticket added; id  = 1 */
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
        if (this.status.equals("regular")) {
            if (this.distance <= 5) {
                this.fareRate = minimumFareRateForReg;
            } else {
                this.fareRate = ((this.distance - minimumDistance) * succeedingKilometerForReg) + minimumFareRateForReg;
            }

            /** If passenger is not regular */
        } else if (this.status.equals("pwd") || this.status.equals("student") || this.status.equals("senior citizen")) {
            if (this.distance <= 5) {
                this.fareRate = minimumFareRateForNotReg;
            } else {
                this.fareRate = ((this.distance - minimumDistance) * succeedingKilometerForNotReg) + minimumFareRateForNotReg;
            }
        }
    }


    /**
     * Update ticket
     */
    public void updateTicket() {

        /** Call out searchTicket method to check if there's data */
        searchTicket();

        if (!isError) {
            System.out.print("Enter your new Name: ");
            String passengerNameToReplace = scan.nextLine();
            for (ReservationTicket reserves : reservationTickets) {
                if (id == reserves.id && Objects.equals(nameOfPassenger, reserves.nameOfPassenger) && busNo == reserves.busNo) {
                    /** update passenger name*/

                    System.out.println(reserves.nameOfPassenger);
                    reserves.setNameOfPassenger(passengerNameToReplace);

                    System.out.println("\n\t\tTicket updated!");
                    System.out.println("Name: " + reserves.nameOfPassenger);
                    System.out.println("Status: " + reserves.status);
                    System.out.println("Origin: " + reserves.origin);
                    System.out.println("Destination: " + reserves.destination);
                    System.out.println("Date: " + reserves.date);
                    System.out.println("Fare rate: " + reserves.fareRate + " \n");
                    break;
                }
            }
        }

    }

    /**
     * Search ticket
     */
    public void searchTicket() {

        for (int i = 0; i < i + 1; i++) {

            if (i == 1) {
                System.out.print("Your current id: ");
                id = scan.nextInt();
                scan.nextLine();
                System.out.print("Your current name: ");
                nameOfPassenger = scan.nextLine();
                System.out.print("Bus Number: ");
                busNo = scan.nextInt();
                scan.nextLine();

                /** Check the size/length of our arraylist reservationTickets*/
                if (reservationTickets.size() != 0) {

                    /** Loop our reservationTicket so that we get access to its elements*/
                    for (ReservationTicket reserves : reservationTickets) {
                        /** if ticket found then display*/
                        if (id == reserves.id && Objects.equals(nameOfPassenger, reserves.nameOfPassenger) && busNo == reserves.busNo) {
                            System.out.println("\n\t\tFound Ticket!");
                            System.out.println("Name: " + reserves.nameOfPassenger);
                            System.out.println("Status: " + reserves.status);
                            System.out.println("Origin: " + reserves.origin);
                            System.out.println("Destination: " + reserves.destination);
                            System.out.println("Distance: " + reserves.distance);
                            System.out.println("Date : " + reserves.date);
                            System.out.println("Fare rate: " + reserves.fareRate + " \n");
                            isError = false;
                            break;
                        } else {
                            isError = true;
                        }

                    }
                }

                if (isError) {
                    System.out.println("Can't find ticket! try again...\n");
                }
            }
        }
    }

    /**
     * Display all  tickets
     */
    public void displayReservationTickets() {

        if (reservationTickets.size() == 0) {
            System.out.println("\n\nSorry no Record Yet!\n");
        } else {
//            the "-" symbol means align String to left
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

