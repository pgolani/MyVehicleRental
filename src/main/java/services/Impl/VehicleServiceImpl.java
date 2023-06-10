package services.Impl;

import dto.VehicleDTO;
import entities.BookingTime;
import entities.Branch;
import entities.Vehicle;
import factory.VehicleFactory;
import lombok.AllArgsConstructor;
import managers.BranchManager;
import managers.VehicleManager;
import services.VehicleService;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {
        BranchManager branchManager;
        VehicleFactory vehicleFactory;
        VehicleManager vehicleManager;

    @Override
    public boolean onBoardVehicle(VehicleDTO vehicleDTO) {
            Branch branch = branchManager.getBranch(vehicleDTO.getBranchId());
            boolean typePresent=false;
            for(String type : branch.getVehicletypes()){
                if(type.equals(vehicleDTO.getType())){
                    typePresent=true;
                }
            }
            if(!typePresent)return false;
            try{
                Vehicle vehicle= vehicleFactory.addVehicle(vehicleDTO);
                return vehicleManager.addVehicle(vehicle);
            }
            catch (IllegalArgumentException e){
                return false;
            }
    }

    @Override
    public boolean discardVehicle(String id) {
                return vehicleManager.deleteVehicle(id);
    }

    @Override
    public List<String> displayVehiclebyBranch(String id, Integer startTime, Integer endTime) {
            List<Vehicle>vehicles = vehicleManager.getAllVehicleBybranch(id);
            List<String>display = new ArrayList<>();
            for(Vehicle v : vehicles){
                boolean free = true;
                List<BookingTime> bk = v.getBookingTime();
                for(BookingTime b : bk){
                    if (startTime >= b.getStarttime() && startTime <= b.getEndtime()) {
                        free = false; break;
                    }
                    if (endTime >= b.getStarttime() && endTime <= b.getEndtime()) {
                        free = false; break;
                    }
                    if (startTime < b.getStarttime() && endTime > b.getEndtime()) {
                        free = false; break;
                    }
                }
                if(free){
                    display.add(v.getId());
                }
            }
            return display;
    }
}
