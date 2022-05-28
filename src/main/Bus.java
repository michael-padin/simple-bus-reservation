package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Bus{
   private int busNo;
   private  String busName;
   private String destination;
   private String origin;
   private int capacity;

   Bus(int busNo, String busName, String origin, String destination, int capacity) {
       super();
        this.busNo = busNo;
        this.busName = busName;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
    }


     static {
    List<Bus> bus = new ArrayList<>();
    bus.add(new Bus(101,    "ceres1", "csbt", "samboan", 17));
    bus.add(new Bus(102, "ceres2", "csbt", "oslob", 17));
    bus.add(new Bus(103, "ceres3", "csbt", "alcoy", 17));
    bus.add(new Bus(104, "ceres4", "csbt", "argao", 17));
    bus.add(new Bus(104, "ceres4", "csbt", "carcar", 17));
    }

    public Bus() {
        
    }
}



