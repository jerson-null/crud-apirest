package com.apirest.crud.demo.repositories;

import com.apirest.crud.demo.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
