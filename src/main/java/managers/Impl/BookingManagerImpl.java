package managers.Impl;

import entities.*;
import lombok.AllArgsConstructor;
import managers.BookingManager;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
public class BookingManagerImpl implements BookingManager {

    VehicleManagerImpl vehicleManager;

    @Override
    public Integer bookCar(String branchId, Integer starttime, Integer endtime) {
        List<Vehicle>vehicles = vehicleManager.getAllVehicleBybranchandtypeorderByprice(branchId , VehicleType.CAR);

        List<Car> availableCars= new ArrayList<>();
        for(Vehicle v : vehicles){
            boolean free =true;
            for(BookingTime b : v.getBookingTime()){
                if(starttime >=b.getStarttime() && starttime <=b.getEndtime()){
                    free=false;
                }
                if(endtime>=b.getStarttime() && endtime<=b.getEndtime()){
                    free= false;
                }
                if(starttime<= b.getStarttime() && endtime>=b.getEndtime()){
                    free= false;
                }
            }
            if(free){
                Car car = new Car(v.getId(),v.getBranchId(),v.getPrice());
                availableCars.add(car);
            }
        }
        Integer bookingPrice = -1;
        if(availableCars.isEmpty())return bookingPrice;

        vehicleManager.setBookingTimeForVehicle(availableCars.get(0).getId() , starttime , endtime);

        return availableCars.get(0).getPrice()*(endtime-starttime);
    }

    @Override
    public Integer bookBike(String branchId, Integer starttime, Integer endtime) {
        List<Vehicle>vehicles = vehicleManager.getAllVehicleBybranchandtypeorderByprice(branchId , VehicleType.BIKE);

        List<Bike> availableBikes= new ArrayList<>();
        for(Vehicle v : vehicles){
            boolean free =true;
            for(BookingTime b : v.getBookingTime()){
                if(starttime >=b.getStarttime() && starttime <=b.getEndtime()){
                    free=false;
                }
                if(endtime>=b.getStarttime() && endtime<=b.getEndtime()){
                    free= false;
                }
                if(starttime<= b.getStarttime() && endtime>=b.getEndtime()){
                    free= false;
                }
            }
            if(free){
                Bike bike = new Bike(v.getId(),v.getBranchId(),v.getPrice());
                availableBikes.add(bike);
            }
        }
        Integer bookingPrice = -1;
        if(availableBikes.isEmpty())return bookingPrice;

        vehicleManager.setBookingTimeForVehicle(availableBikes.get(0).getId() , starttime , endtime);

        return availableBikes.get(0).getPrice()*(endtime-starttime);
    }


}
