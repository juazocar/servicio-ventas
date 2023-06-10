package cl.duoc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.api.model.VentaDTO;
import cl.duoc.api.service.VentasService;

@RestController
public class VentasController {

    //int total, String fecha, int idProducto

    @Autowired
    VentasService ventasService;

    @PostMapping(path = "/crear-venta")
    public String generarVenta(@RequestBody VentaDTO ventaDTO){
        
        return ventasService.generarVentaDesdeService(ventaDTO);
    }
    
}
