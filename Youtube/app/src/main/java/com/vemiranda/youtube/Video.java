package com.vemiranda.youtube;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Video {
    private String urlPhoto;
    private String titulo;
    private String usuario;
    private String visualizaciones;
    private String duracion;
}
