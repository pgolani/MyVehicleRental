package dto;

import entities.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VehicleDTO {
        private String id;
        private String branchId;
        private Integer price;
        private String type;

}
