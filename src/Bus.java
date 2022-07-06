import java.util.ArrayList;
import java.util.Collections;

public class Bus {
    private int busNo;
    private String busName;
    private String destination;
    private String origin;
    private ArrayList<Integer> capacity = new ArrayList<>();

    public Bus(int busNo, String busName, String origin, String destination, ArrayList<Integer> capacity) {
        this.busNo = busNo;
        this.busName = busName;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
    }

    Bus() {}

    public void displayBus(ArrayList<Bus> buses) {

        System.out.format("\n+%-10s+%-20s+%-15s+%-15s+%-10s+\n", "----------", "--------------------", "---------------", "---------------", "----------");
        System.out.format("| %-9s| %-19s| %-14s| %-14s| %-9s|\n", "Bus No.", "Bus Name", "Origin", "Destination", "Capacity");
        System.out.format("+%-10s+%-20s+%-15s+%-15s+%-10s+\n", "----------", "--------------------", "---------------", "---------------", "----------");

        for (Bus bus : buses) {
            System.out.format("| %-9d| %-19s| %-14s| %-14s| %-9d|\n", bus.busNo, bus.busName, bus.origin, bus.destination, bus.capacity.size());
        }
        System.out.format("+%-10s+%-20s+%-15s+%-15s+%-10s+\n", "----------", "--------------------", "---------------", "---------------", "----------");

    }

    /* Getter of our bus number */
    public int getBusNo() {

        return busNo;
    }

    /* Getter of our bus capacity */
    public ArrayList<Integer> getCapacity() {

        /* sort arraylist in ascending order*/
        Collections.sort(capacity);
        return capacity;
    }
}



