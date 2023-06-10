package managers;

public interface BookingManager {

    public Integer bookCar(String branchId , Integer starttime , Integer endtime);

    public Integer bookBike(String branchId , Integer starttime , Integer endtime);
}
