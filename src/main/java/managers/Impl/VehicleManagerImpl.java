package managers.Impl;

import entities.Branch;
import entities.Vehicle;
import entities.VehicleType;
import managers.VehicleManager;
import repo.Repo;
import util.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleManagerImpl implements VehicleManager {

    Repo repo;
    public VehicleManagerImpl(Repo repo){
        this.repo=repo;
    }

    @Override
    public List<Vehicle> getAllVehicleBybranchandtypeorderByprice(String branchId, VehicleType type) {
        List<Vehicle> vehicles = new ArrayList<>();
        for(String vehicleId : repo.vehicleRepo.keySet()){
            if(repo.vehicleRepo.get(vehicleId).getBranchId().equals(branchId) && repo.vehicleRepo.get(vehicleId).getType().equals(type)){
                vehicles.add(repo.vehicleRepo.get(vehicleId));
            }
        }
        Collections.sort(vehicles , new util.PriceComparator());
        return vehicles;


    }

    @Override
    public void setBookingTimeForVehicle(String id, Integer starttime, Integer endtime) {
        repo.vehicleRepo.get(id).addBookingTime(starttime,endtime);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
            if(repo.vehicleRepo.containsKey(vehicle.getId())){
                return false;
            }
            else{
                repo.vehicleRepo.put(vehicle.getId(),vehicle);
                return true;
            }
    }

    @Override
    public boolean deleteVehicle(String id) {
        if (repo.vehicleRepo.containsKey(id)){
            repo.vehicleRepo.remove(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public List<Vehicle> getAllVehicleBybranch(String branchId) {
        List<Vehicle>vehicles = new ArrayList<>();
        for(String id : repo.vehicleRepo.keySet()){
            if(repo.vehicleRepo.get(id).getBranchId().equals(branchId)){
                vehicles.add(repo.vehicleRepo.get(id));
            }
        }
        return vehicles;
    }
}
