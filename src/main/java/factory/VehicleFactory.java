package factory;

import dto.VehicleDTO;
import entities.Bike;
import entities.Car;
import entities.Vehicle;

public class VehicleFactory {

    public Vehicle addVehicle(VehicleDTO vehicleDTO) throws  IllegalArgumentException{
            switch (vehicleDTO.getType().toLowerCase()){
                case "car" : return new Car(vehicleDTO.getId() , vehicleDTO.getBranchId(),vehicleDTO.getPrice());
                case "bike" : return new Bike(vehicleDTO.getId(),vehicleDTO.getBranchId(),vehicleDTO.getPrice());
                default: throw new IllegalArgumentException();
            }
    }
}
