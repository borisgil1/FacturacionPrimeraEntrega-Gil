package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "nombreProducto")
    @Getter
    @Setter
    private String nombre;

    @Column(name="precio")
    @Getter
    @Setter
    private Integer precio;
}
