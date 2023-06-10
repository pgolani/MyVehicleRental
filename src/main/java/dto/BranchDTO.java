package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class BranchDTO {

    private String id;
    private List<String> Vehicletype;
}
