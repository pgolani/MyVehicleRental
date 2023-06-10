package managers;

import entities.Vehicle;
import entities.VehicleType;

import java.util.List;

public interface VehicleManager {

    public List<Vehicle> getAllVehicleBybranchandtypeorderByprice(String branchId , VehicleType type);

    public void setBookingTimeForVehicle(String id , Integer starttime ,Integer endtime);

    public boolean addVehicle(Vehicle vehicle);

    public boolean deleteVehicle(String id);
    public List<Vehicle> getAllVehicleBybranch(String branchId );
}
