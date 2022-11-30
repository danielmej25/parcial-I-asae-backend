package co.edu.unicauca.parcial.services.DTO;

import co.edu.unicauca.parcial.models.Curso;
import co.edu.unicauca.parcial.models.Docente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaDTO {

    private Integer id;
    private String nombre;

    private List<Curso> cursos;
    private List<Docente> docentes;
}
