package entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public abstract class Vehicle {

    private String id;
    private VehicleType type;
    private Integer price;
    private String branchId;
    private List<BookingTime> bookingTime;

    public  Vehicle(String id , VehicleType type , Integer price , String branchId){
        this.id=id;
        this.type=type;
        this.price= price;
        this.branchId=branchId;
        this.bookingTime=new ArrayList<>();
    }

    public void addBookingTime(Integer starttime , Integer endtime){
        BookingTime bookingTime1 = new BookingTime(starttime,endtime);
         this.bookingTime.add(bookingTime1);
    }






}
