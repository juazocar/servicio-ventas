package cl.duoc.api.model;

import lombok.Data;

@Data
public class VentaDTO {
    
    private int id;
    private int total;
    private double descuento;
    private String fecha;
    private String webpayToken;
}
