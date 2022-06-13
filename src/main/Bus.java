package main;
import java.util.ArrayList;

public class Bus{
     private int busNo;
     private String busName;
     private String destination;
     private String origin;
     private final ArrayList<Integer> capacity = new ArrayList<>();
     private final ArrayList<Bus> bus = new ArrayList<>();

  public Bus(int busNo, String busName, String origin, String destination, int capacity) {
        this.busNo = busNo;
        this.busName = busName;
        this.origin = origin;
        this.destination = destination;
        for (int i = 1; i <= capacity; i++) {
            this.capacity.add(i);
        }
    }

    public ArrayList<Bus> getBus() {
        return bus;
    }

    public int getBusNo() {
        return busNo;
    }

    public String getBusName() {
        return busName;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public ArrayList<Integer> getCapacity() {
        return capacity;
    }

    public Bus(){
        bus.add(new Bus(101,    "ceres1", "csbt", "samboan",38));
        bus.add(new Bus(102, "ceres2", "csbt", "oslob",38));
        bus.add(new Bus(103, "ceres3", "csbt", "alcoy",38));
        bus.add(new Bus(104, "ceres4", "csbt", "argao",38));
        bus.add(new Bus(104, "ceres4", "csbt", "carcar", 38));
    }



}



