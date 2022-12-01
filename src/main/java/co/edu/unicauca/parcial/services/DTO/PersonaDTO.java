package co.edu.unicauca.parcial.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PersonaDTO {
    private int id;

    private String noId;

    private String tipoIdentificacion;

    private String nombres;

    private String apellidos;    
}