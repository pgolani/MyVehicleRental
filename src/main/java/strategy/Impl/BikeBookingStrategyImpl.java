package strategy.Impl;

import dto.BookingDTO;
import lombok.AllArgsConstructor;
import managers.BookingManager;
import strategy.BookingStrategy;
@AllArgsConstructor
public class BikeBookingStrategyImpl implements BookingStrategy {

    BookingManager bookingManager;

    @Override
    public Integer bookVehicle(BookingDTO bookingDTO) {
        return bookingManager.bookBike(bookingDTO.getBranchId(),bookingDTO.getStarttime(),bookingDTO.getEndtime());
    }
}
