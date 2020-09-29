import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Parking Lot
// /1/2/3/ / / /... /n/


// parkCar()
// returns :
//    location (where their car has been parked)
//    ticketNumber so they can retrieve their car

// pickupCar(ticketNumber):
// returns: location (where they can find their car)


public class Solution {
    PriorityQueue<Integer> available;

    public Solution(int n) {
        available = new PriorityQueue<Integer>();
        for (int i = 0; i< n; i++) {
            available.add(i);
        }
    }
    
    public int pickupCar(int ticket) {
        available.add(ticket);
        return ticket;
    }
    
    public int[] parkCar() {
        int[] ticketLocation = new int[2];
        Integer location = available.poll();
        if (location == null) {
            ticketLocation[0] = -1;
            ticketLocation[1] = -1;
        } else {
            ticketLocation[0] = location;
            ticketLocation[1] = location;
        }
        return ticketLocation;
        
        
    } 

 public static void main(String[] args) {
   }
}
