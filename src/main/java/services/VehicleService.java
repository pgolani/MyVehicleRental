package services;

import dto.VehicleDTO;
import entities.Vehicle;

import java.util.List;

public interface VehicleService {

    public boolean onBoardVehicle(VehicleDTO vehicleDTO);
    public boolean discardVehicle (String id);

    public List<String> displayVehiclebyBranch(String id , Integer starttime , Integer endtime);
}
