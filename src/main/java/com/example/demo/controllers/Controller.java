package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.models.Producto;
import com.example.demo.models.Venta;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.VentaRepository;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private ProductoRepository repo;

    @Autowired
    private VentaRepository repo;


    @GetMapping
    public  String index(){
        return "Conectado";
    }

    @GetMapping("clientes")
    public List<Cliente> getClientes(){
        return  repo.findAll();
    }

    @GetMapping("productos")
    public List<Producto> getProducto(){
        return  repo.findAll();
    }

    @PostMapping("alta")
    public String post(@RequestBody Cliente cliente){
        repo.save(cliente);
        return "Guardado";
    }

    @PostMapping("alta/producto")
    public String post(@RequestBody Producto producto){
        repo.save(producto);
        return "Producto guardado";
    }

    @PostMapping("alta/venta")
    public String post(@RequestBody Venta venta){
        repo.save(venta);
        return "Venta guardada";
    }

    @PutMapping("modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente updateCliente = repo.findById(id).get();
        updateCliente.setNombre(cliente.getNombre());
        updateCliente.setEmail(cliente.getEmail());
        repo.save(updateCliente);
        return "Cliente modificado";
    }

    @PutMapping("modificarProducto/{id}")
    public String update(@PathVariable Long id, @RequestBody Producto producto){
        Producto updateProducto = repo.findById(id).get();
        updateProducto.setNombre(producto.getNombre());
        updateProducto.setPrecio(producto.getPrecio());
        repo.save(updateProducto);
        return "Producto modificado";
    }

    @PutMapping("modificarVenta/{id}")
    public String update(@PathVariable Long id, @RequestBody Venta venta){
        Venta updateVenta = repo.findById(id).get();
        updateVenta.setCantidad(venta.getCantidad());
        updateVenta.setFecha(venta.getFecha());
        repo.save(updateVenta);
        return "Venta modificada";
    }

    @DeleteMapping("baja/{id}")
    public String delete(@PathVariable Long id){

        Cliente deleteCliente = repo.findById(id).get();
        repo.delete(deleteCliente);
        return "Cliente eliminado";
    }

    @DeleteMapping("bajaProducto/{id}")
    public String delete(@PathVariable Long id){

        Producto deleteProducto = repo.findById(id).get();
        repo.delete(deleteProducto);
        return "Producto eliminado";
    }

    @DeleteMapping("bajaVenta/{id}")
    public String delete(@PathVariable Long id){

        Venta deleteVenta = repo.findById(id).get();
        repo.delete(deleteVenta);
        return "Venta eliminada";
    }
}

