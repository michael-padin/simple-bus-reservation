import java.util.ArrayList;
import java.util.LinkedList;

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

    Bus() {
    }


    public void displayBus(LinkedList<Bus> buses) {

        System.out.format("+%-10s+%-20s+%-15s+%-15s+%-10s+\n", "----------", "--------------------", "---------------", "---------------", "----------");
        System.out.format("|%-10s|%-20s|%-15s|%-15s|%-10s|\n", "Bus No.", "Bus Name", "Origin", "Destination", "Capacity");
        System.out.format("+%-10s+%-20s+%-15s+%-15s+%-10s+\n", "----------", "--------------------", "---------------", "---------------", "----------");
        for (Bus bus : buses) {
            System.out.format("|%-10d|%-20s|%-15s|%-15s|%-10d|\n", bus.busNo, bus.busName, bus.origin, bus.destination, bus.capacity.size());
        }
        System.out.format("+%-10s+%-20s+%-15s+%-15s+%-10s+\n", "----------", "--------------------", "---------------", "---------------", "----------");

    }

    public int getBusNo() {
        return busNo;
    }

    public ArrayList<Integer> getCapacity() {
        return capacity;
    }


}



