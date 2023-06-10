package strategy;

import dto.BookingDTO;

public class BookingContext {
        BookingStrategy bookingStrategy;

        public BookingContext(BookingStrategy bookingStrategy){
            this.bookingStrategy=bookingStrategy;
        }

        public Integer executeStrategy(BookingDTO bookingDTO){
            return bookingStrategy.bookVehicle(bookingDTO);
    }
}
