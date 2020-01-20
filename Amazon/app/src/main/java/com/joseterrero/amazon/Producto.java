package com.joseterrero.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto {
    private String tituloProductoSolicitado;
    private String titulo;
    private String nombreTienda;
    private String precio;
    private String nombreServicioPremium;
    private String fechaRecibo;
    private String servicioEnvio;
    private String disponibilidad;
    private float valoracion;
    private int cantidadComentarios;
    private String variantesProductos;
    private String urlPhoto;
}
