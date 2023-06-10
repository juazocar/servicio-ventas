package cl.duoc.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.api.client.WebPayFeignClient;
import cl.duoc.api.model.VentaDTO;
import cl.duoc.api.model.WebPayInitTransactionDTO;

@Service
public class VentasService {

    @Autowired
    WebPayFeignClient webPayFeignClient;

    public String generarVentaDesdeService(VentaDTO ventaDTO){
       
        double descuento = ventaDTO.getTotal()*0.1;
        ventaDTO.setDescuento(descuento);

        int amount =  ventaDTO.getTotal() - (int) descuento;
       
        WebPayInitTransactionDTO webPayInitTransactionDTO = new WebPayInitTransactionDTO();
        webPayInitTransactionDTO.setBuyOrder("OC001");    
        webPayInitTransactionDTO.setSessionId("SI00000001");
        webPayInitTransactionDTO.setAmount(amount);
        webPayInitTransactionDTO.setReturnUrl("http://www.musicpro.cl/pagina_exito.html");
        webPayFeignClient.createTransaction("597055555532", "579B532A7440BB0C9079DED94D31EA1615BACEB56610332264630D42D0A36B1C", webPayInitTransactionDTO); 
       
        return ventaDTO.toString();
    }
    
}
