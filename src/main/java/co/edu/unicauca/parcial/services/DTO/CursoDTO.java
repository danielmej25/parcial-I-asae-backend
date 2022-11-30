package co.edu.unicauca.parcial.services.DTO;

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

    private AsignaturaDTO asignaturaDTO;
}