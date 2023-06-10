package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class Branch {

    private String branchId;
    private List<String> Vehicletypes;
}
