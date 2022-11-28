package co.edu.unicauca.parcial.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class TelefonoDTO {
    
    private int id;

    private String tipo;

    private String numero;

    //TODO: verificar si es necesario un estudiante para la maperar y brindar info
}
