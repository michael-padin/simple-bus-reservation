import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ReservationTicket {
    private static final ArrayList<ReservationTicket> reservationTickets = new ArrayList<>();
    private static boolean isError;
    private static String message;
    /*
     * Store our object in ArrayList so that we can
     * access it later
     */
    Scanner scan = new Scanner(System.in);

    /* attributes of our className*/
    private int id = 1;
    private int busNo;
    private int seatNo;
    private double fareRate;
    private double distance;
<<<<<<< HEAD
    private String nameOfPassenger; // sample
=======
    private String nameOfPassenger;
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
    private String status;
    private String origin;
    private String destination;
    private String date;

<<<<<<< HEAD
    /* Constructor of our ticket object*/
=======
    /* Constructor of our ticket*/
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
    ReservationTicket(int id, int busNo, String nameOfPassenger, String origin, String destination, String date, int seatNo, String status, double fareRate, double distance) {
        this.id = id;
        this.busNo = busNo;
        this.nameOfPassenger = nameOfPassenger;
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.seatNo = seatNo;
        this.date = date;
        this.fareRate = fareRate;
        this.distance = distance;
    }

/* empty constructor para ma access nato ang iyahang methods if ato ning ih call*/
    ReservationTicket() {
    }

<<<<<<< HEAD
=======
    ReservationTicket() {
    }

>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
    /* get data from user input using our addTicket() method*/
    public void addTicket(ArrayList<Bus> buses) {
        LocalDate localDate;

<<<<<<< HEAD
        /* we call our setId() method to Generate an id for our user */
=======
        /* call our setId() method to Generate an id for our user */
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
        setId();

        for (int i = 0; i < 7; i++) {

            if (i == 0) {
                System.out.print("Enter bus Number: ");
                this.busNo = scan.nextInt();

                for (Bus bus : buses) {

                    /* if ang gi input sa user is equals sa bus number then proceed*/
                    if (this.busNo == bus.getBusNo()) {
                        if (bus.getCapacity().size() == 0) {
                            isError = true;
                        } else {
                            System.out.println("\nAvailable seats: " + bus.getCapacity().toString());
                            isError = false;
                            i = 2;
                        }
                    } else {
                        i--;
                    }
                }
<<<<<<< HEAD

=======
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
                if (isError) {
                    System.out.println("Bus is full! try other bus or try again next time");
                    isError = false;
                    break;
                }
            }
            if (i == 2) {

                /* Input seat number*/
                System.out.print("Enter Seat: ");
                seatNo = scan.nextInt();
                scan.nextLine();

<<<<<<< HEAD
                /* we Loop our bus arraylist to get the specific element / object */
                for (Bus b : buses) {

                    /* Check if inputted bus number kung mo match sa among in buse object */
=======
                /* Loop our bus arraylist to get the elements of bus capacity*/
                for (Bus b : buses) {

                    /* Check if inputted bus number is available in buses*/
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
                    if (b.getBusNo() == this.busNo) {

                        /* if bus seat number is equal to the inputted seat number we then remove
                         *  the element in our arraylist seat number
                         * */
                        if (b.getCapacity().contains(this.seatNo)) {

                            /* the remove() predefined method is to remove the specific element in
                             *  our arraylist.
                             * */
                            b.getCapacity().remove((Integer) this.seatNo);
                            i += 2;
                        } else {
                            System.out.println("Seat is occupied, try another one");

                            /* decrement our i if the inputted seat number is not available in our arraylist
<<<<<<< HEAD
                             *  so that it will go back to ask again a seat number.
=======
                             *  so that it will go back to ask a seat number.
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
                             * */
                            i--;
                        }
                    }
                }
            }

            if (i == 4) {

                /* Input name of passenger*/
                System.out.print("Name: ");
                nameOfPassenger = scan.nextLine();

                /* Input status of passenger*/
                System.out.println("Status: [regular, pwd, senior, student]");
                status = scan.next();

                /* Set date*/
                System.out.print("Date: dd-mm-yyyy: ");
                String inputDate = scan.next();

                /*format date using date formatter*/
                DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                localDate = LocalDate.parse(inputDate, formatDate);
                this.date = localDate.toString();

                System.out.print("Origin: ");
                this.origin = scan.next();
                System.out.print("Destination: ");
                this.destination = scan.next();
                System.out.print("Distance from Origin to Destination: ");
                this.distance = scan.nextDouble();

                /* call our setFareRate method to update our fare Rate */
                setFareRate();

                /* Create our object and add it in our array list so that we can access it later*/
                reservationTickets.add(new ReservationTicket(id, busNo, nameOfPassenger, origin, destination, date, seatNo, status, fareRate, distance));

                /* set our globe variable message to "ticket added" since we are adding a ticket*/
                message = "TICKET ADDED!";
                displaySingleTicket();
                break;
            }
        }
    }

<<<<<<< HEAD
    /* Setter of our passenger name*/   //michael
=======
    /* Setter of our passenger name*/
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
    public void setNameOfPassenger(String nameOfPassenger) {
        // sample                   //michael
        this.nameOfPassenger = nameOfPassenger;
    }

    /* The setter or our id */
    void setId() {
        for (ReservationTicket t : reservationTickets) {
            /** ticket added; id  = 1 */
            if (this.id == t.id) {
                this.id++;
            }
        }
    }

    /* Set fare rate base on inputted distance */
    public void setFareRate() {
        double minimumDistance = 5;
        final double minimumFareRateForReg = 11;
        final double minimumFareRateForNotReg = 8.75;

        final double succeedingPerKilometerForNotReg = 1.48;
        final double succeedingPerKilometerForReg = 1.85;

        /* If passenger is  regular */
        if (this.status.equals("regular")) {
            if (this.distance <= 5) {
                this.fareRate = minimumFareRateForReg;
            } else {                //20               // 5                 // 1.85
                this.fareRate = ((this.distance - minimumDistance) * succeedingPerKilometerForReg) + minimumFareRateForReg;
            }

            /* If passenger is not regular */
        } else if (this.status.equals("pwd") || this.status.equals("student") || this.status.equals("senior")) {
            if (this.distance <= 5) {
                this.fareRate = minimumFareRateForNotReg;
            } else {
                this.fareRate = ((this.distance - minimumDistance) * succeedingPerKilometerForNotReg) + minimumFareRateForNotReg;
            }
        }
    }

    /* Search ticket method*/
    public void searchTicket() {

        System.out.print("Your current id: ");
        id = scan.nextInt();
        scan.nextLine();
        System.out.print("Your current name: ");
        nameOfPassenger = scan.nextLine();
        System.out.print("Bus Number: ");
        busNo = scan.nextInt();
        scan.nextLine();

        /* Check the size/length of our arraylist reservationTickets*/
        if (reservationTickets.size() != 0) {

            message = "YOUR TICKET";
            displaySingleTicket();
        } else {
            isError = true;
        }

        if (isError) {
            System.out.println("Can't find ticket! try again...\n");
        }
    }


    /*  Update ticket method */
    public void updateTicket() {

        /* Call our searchTicket() method to check/verify if sakto ba ang iyang data nga updaton */
        searchTicket();

        if (!isError) {
            System.out.print("Enter your new Name: ");
            String passengerNameToReplace = scan.nextLine();

            for (ReservationTicket ticket : reservationTickets) {
                if (this.id == ticket.id && Objects.equals(nameOfPassenger, ticket.nameOfPassenger) && busNo == ticket.busNo) {

                    /** update passenger name using our setter method which is setNameOfPassenger() */
                    ticket.setNameOfPassenger(passengerNameToReplace);
<<<<<<< HEAD
                    nameOfPassenger = passengerNameToReplace;
=======
                    this.nameOfPassenger = passengerNameToReplace;
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc

                    /* Set our global variable ticket to "ticket updated" since we're updating a ticket*/
                    message = "TICKET UPDATED!";

                    /* Call our displaySingleTicket() method to print the updated information of the user*/
                    displaySingleTicket();
                    break;
                }
            }
        }

    }


<<<<<<< HEAD
    /* display ticket */
=======
    /* display single ticket */
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
    public void displaySingleTicket() {

        /* Loop our reservationTicket so that we get access to its elements*/
        for (ReservationTicket ticket : reservationTickets) {

<<<<<<< HEAD
            /* check to see if the user's information matches the inserted item in our arraylist.t*/
=======
            /* if inputted information of the user is match to the added object in our arraylist*/
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
            if (id == ticket.id && Objects.equals(nameOfPassenger, ticket.nameOfPassenger) && busNo == ticket.busNo) {
                System.out.println("\n\t" + message + "\n");
                System.out.println("Id: " + ticket.id);
                System.out.println("Name: " + ticket.nameOfPassenger);
                System.out.println("Bus No: " + ticket.busNo);
                System.out.println("Seat No: " + ticket.seatNo);
                System.out.println("Status: " + ticket.status);
                System.out.println("Origin: " + ticket.origin);
                System.out.println("Destination: " + ticket.destination);
                System.out.println("Distance: " + ticket.distance);
                System.out.println("Date : " + ticket.date);
                System.out.println("Fare rate: " + Math.round(ticket.fareRate) + " \n");
                isError = false;
                break;
            } else {
                isError = true;
            }
        }
    }

<<<<<<< HEAD
    /* Display tickets*/
=======
    /* Display all  tickets*/
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
    public void displayReservationTickets() {
        if (reservationTickets.size() == 0) {
            System.out.println("\n\nSorry no Record Yet!\n");
        } else {
//            the "-" symbol means align String to left
<<<<<<< HEAD
//            number[s] or "5s" means numbers of space nga ih occupy
=======
>>>>>>> 4a0a7b1a35a5d818436f98f37eb2c59e213906dc
            System.out.format("+%-5s+%-9s+%-9s+%-20s+%-15s+%-15s+%-10s+%-10s+%-13s+%-11s+\n", "-----", "---------","---------", "--------------------", "---------------", "---------------", "----------", "----------", "-------------", "-----------");
            System.out.format("| %-4s| %-8s| %-8s| %-19s| %-14s| %-14s| %-9s| %-9s| %-12s| %-10s|\n", "Id", "Bus No", "Seat No", "Name", "Origin", "Destination", "Distance", "Status", "Date", "Fare Rate");
            System.out.format("+%-5s+%-9s+%-9s+%-20s+%-15s+%-15s+%-10s+%-10s+%-13s+%-11s+\n", "-----", "---------","---------", "--------------------", "---------------", "---------------", "----------", "----------", "-------------", "-----------");
            for (ReservationTicket t : reservationTickets) {
                System.out.format("| %-4s| %-8s| %-8s| %-19s| %-14s| %-14s| %-9s| %-9s| %-12s| %-10d|\n", t.id, t.busNo, t.seatNo, t.nameOfPassenger, t.origin, t.destination, t.distance + "km", t.status, t.date, Math.round(t.fareRate));
            }
            System.out.format("+%-5s+%-9s+%-9s+%-20s+%-15s+%-15s+%-10s+%-10s+%-13s+%-11s+\n", "-----", "---------","---------", "--------------------", "---------------", "---------------", "----------", "----------", "-------------", "-----------");
        }
    }
}

