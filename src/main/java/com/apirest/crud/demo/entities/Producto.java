package com.apirest.crud.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Producto")
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto", nullable = false)
    private Long idProducto;

    @Column(name = "nombreProducto", nullable = false)
    private String nombreProducto;

    @Column(name = "categoriaProducto", nullable = false)
    private String categoriaProducto;

    @Column(name = "precioProducto", nullable = false)
    private double precioProducto;

}
