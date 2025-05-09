package com.example.partlybackend.DTO;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ElectricalAssemblyDTO {
    private String assemblyName;
    private String description;
    private List<ComponentQuantityDTO> components;
}
