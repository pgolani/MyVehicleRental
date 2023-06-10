package entities;

public class Car extends Vehicle{

    public Car(String id , String branchId , Integer price){
        super(id , VehicleType.CAR ,price , branchId );
    }
}
