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
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VentaRepository ventaRepository;


    @GetMapping
    public String index() {
        return "Conectado";
    }

    @GetMapping("clientes")
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("productos")
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("ventas")
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @PostMapping("alta/cliente")
    public String postCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return "Cliente guardado";
    }

    @PostMapping("alta/producto")
    public String postProducto(@RequestBody Producto producto) {
        productoRepository.save(producto);
        return "Producto guardado";
    }

    @PostMapping("alta/venta")
    public String postVenta(@RequestBody Venta venta) {
        ventaRepository.save(venta);
        return "Venta guardada";
    }

    @PutMapping("modificarCliente/{id}")
    public String updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente updateCliente = clienteRepository.findById(id).get();
        updateCliente.setNombre(cliente.getNombre());
        updateCliente.setEmail(cliente.getEmail());
        clienteRepository.save(updateCliente);
        return "Cliente modificado";
    }

    @PutMapping("modificarProducto/{id}")
    public String updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto updateProducto = productoRepository.findById(id).get();
        updateProducto.setNombre(producto.getNombre());
        updateProducto.setPrecio(producto.getPrecio());
        productoRepository.save(updateProducto);
        return "Producto modificado";
    }

    @PutMapping("modificarVenta/{id}")
    public String updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        Venta updateVenta = ventaRepository.findById(id).get();
        updateVenta.setCantidad(venta.getCantidad());
        updateVenta.setFecha(venta.getFecha());
        ventaRepository.save(updateVenta);
        return "Venta modificada";
    }

    @DeleteMapping("bajaCliente/{id}")
    public String deleteCliente(@PathVariable Long id) {

        Cliente deleteCliente = clienteRepository.findById(id).get();
        clienteRepository.delete(deleteCliente);
        return "Cliente eliminado";
    }

    @DeleteMapping("bajaProducto/{id}")
    public String deleteProducto(@PathVariable Long id) {

        Producto deleteProducto = productoRepository.findById(id).get();
        productoRepository.delete(deleteProducto);
        return "Producto eliminado";
    }

    @DeleteMapping("bajaVenta/{id}")
    public String deleteVenta(@PathVariable Long id) {

        Venta deleteVenta = ventaRepository.findById(id).get();
        ventaRepository.delete(deleteVenta);
        return "Venta eliminada";
    }
}
