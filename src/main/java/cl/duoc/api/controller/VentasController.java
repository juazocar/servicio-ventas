package cl.duoc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.api.model.VentaDTO;
import cl.duoc.api.service.VentasService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class VentasController {

    //int total, String fecha, int idProducto

    @Autowired
    VentasService ventasService;

    @PostMapping(path = "/crear-venta")
    public String generarVenta(@RequestBody VentaDTO ventaDTO){
        log.info("Llamado desde el controller");
        return ventasService.generarVentaDesdeService(ventaDTO);
    }
    
}
