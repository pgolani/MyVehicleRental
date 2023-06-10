package services.Impl;

import dto.BookingDTO;
import managers.BookingManager;
import services.BookingService;
import strategy.BookingContext;
import strategy.Impl.BikeBookingStrategyImpl;
import strategy.Impl.CarBookingStrategyImpl;

public class BookingServiceImpl implements BookingService {

    BookingManager bookingManager;
    public BookingServiceImpl(BookingManager bookingManager){
        this.bookingManager=bookingManager;
    }
    @Override
    public Integer bookVehicle(BookingDTO bookingDTO) {
        BookingContext bookingContext;

        switch (bookingDTO.getType().toLowerCase()){
            case "car" : bookingContext= new BookingContext(new CarBookingStrategyImpl(bookingManager));
            break;

            case "bike": bookingContext= new BookingContext(new BikeBookingStrategyImpl(bookingManager));
            break;
            default: bookingContext=null;

        }
        if (bookingContext==null)return -1;
        else{
            return  bookingContext.executeStrategy(bookingDTO);
        }

    }
}
