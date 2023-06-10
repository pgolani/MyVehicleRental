package strategy;

import dto.BookingDTO;

public interface BookingStrategy {

    public Integer bookVehicle(BookingDTO bookingDTO);
}
