package com.babel.liquidaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Risk {
    @Id
    private String code;
    private String name;
}
