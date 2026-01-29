package com.apirest.crud.demo.controllers;

import com.apirest.crud.demo.entities.Producto;
import com.apirest.crud.demo.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> listarTodosProducto(){
        return productoRepository.findAll();
    }

    @GetMapping("/{idProducto}")
    public Producto listarProductoPorId(@PathVariable Long idProducto){
        return productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("no hay el producto por el id que esta buscando: " + idProducto));
    }


    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{idProducto}")
    public Producto actualizarProdcuto(@PathVariable Long idProducto, @RequestBody Producto producto){
        Producto encontrarProducto  = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("no hay el producto por el id que esta buscando: " + idProducto));

        producto.setNombreProducto(producto.getNombreProducto());
        producto.setCategoriaProducto(producto.getCategoriaProducto());
        producto.setPrecioProducto(producto.getPrecioProducto());

        return  productoRepository.save(producto);
    }

    @DeleteMapping("/{idProducto}")
    public Boolean eliminarProducto(@PathVariable Long idProducto){
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("El producto con ese id no se encuentra " + idProducto));
        productoRepository.deleteById(idProducto);
        return true;
    }
}
