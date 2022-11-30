package co.edu.unicauca.parcial.services.DTO;

import co.edu.unicauca.parcial.models.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    
    private int id;
    private String nombre;
    private int periodo;

    private Asignatura objAsignatura;
}
