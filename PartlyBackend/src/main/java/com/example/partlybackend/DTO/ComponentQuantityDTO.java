package com.example.partlybackend.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComponentQuantityDTO {
    @JsonProperty("componentId")

    private Integer componentId;
    private int quantity;
}
