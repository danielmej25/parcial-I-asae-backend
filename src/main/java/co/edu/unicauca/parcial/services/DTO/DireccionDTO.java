package co.edu.unicauca.parcial.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  @Setter @AllArgsConstructor @NoArgsConstructor
public class DireccionDTO {
    //TODO: comprobar si al hacer mapeo es necesario estudiante

    private String direccionResidencia;

    private String ciudad;

    private String pais;
    
}
