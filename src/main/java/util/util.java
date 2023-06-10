package util;

import entities.Vehicle;

import java.util.Comparator;

public class util {


    public static class  PriceComparator implements Comparator<Vehicle>{

        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            return v1.getPrice().compareTo(v2.getPrice());

        }
    }
}
