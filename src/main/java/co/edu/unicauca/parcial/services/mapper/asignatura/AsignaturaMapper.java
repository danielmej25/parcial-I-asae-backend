package co.edu.unicauca.parcial.services.mapper.asignatura;

import co.edu.unicauca.parcial.models.Asignatura;
import co.edu.unicauca.parcial.models.Curso;
import co.edu.unicauca.parcial.services.DTO.AsignaturaDTO;
import co.edu.unicauca.parcial.services.mapper.Simple;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public abstract class AsignaturaMapper {

    @BeforeMapping
    protected void flushEntity(Asignatura asignatura) {
        if(asignatura != null){
            List<Curso> cursos = asignatura.getCursos();
            cursos.forEach(curso -> curso.setAsignatura(null));
            asignatura.setCursos(cursos);
        }
    }
    @Simple
    @Mapping(target = "docentes", ignore = true)
    public abstract AsignaturaDTO entityToDto(Asignatura entity);

    public abstract Asignatura dtoToEntity(AsignaturaDTO dto);

    @IterableMapping(qualifiedBy = Simple.class)
    public abstract List<AsignaturaDTO> entityToDto(List<Asignatura> entityList);
}


