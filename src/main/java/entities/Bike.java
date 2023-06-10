package entities;

public class Bike extends Vehicle{

    public Bike(String id , String branchId, Integer price){
        super(id ,VehicleType.BIKE , price ,branchId);

    }
}
