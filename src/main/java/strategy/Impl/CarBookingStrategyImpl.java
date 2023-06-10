package strategy.Impl;

import dto.BookingDTO;
import managers.BookingManager;
import strategy.BookingContext;
import strategy.BookingStrategy;

public class CarBookingStrategyImpl implements BookingStrategy {

    BookingManager bookingManager;
    public CarBookingStrategyImpl(BookingManager bookingManager){
        this.bookingManager=bookingManager;
    }
    @Override
    public Integer bookVehicle(BookingDTO bookingDTO) {
        return bookingManager.bookCar(bookingDTO.getBranchId() , bookingDTO.getStarttime() , bookingDTO.getEndtime());
    }
}
