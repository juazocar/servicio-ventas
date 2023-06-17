package cl.duoc.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.duoc.api.model.VentaDTO;

@FeignClient(name = "venta-db", url = "http://localhost:8181")
public interface VentaDbFeignClient {
    
    @PostMapping(path = "/crear-venta", produces = {"application/json"})
    public String crearVenta(@RequestBody VentaDTO ventaDTO);
 
}
