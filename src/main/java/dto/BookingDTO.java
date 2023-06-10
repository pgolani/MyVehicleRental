package dto;

import entities.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookingDTO {

    private String id;
    private Integer starttime;
    private Integer endtime;
    private String type;

    private String branchId;

}
