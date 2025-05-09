package com.example.partlybackend.Entity;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AssemblyComponentId implements Serializable {
    private Integer assembly;
    private Integer component;
}
