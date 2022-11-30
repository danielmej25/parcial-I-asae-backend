package co.edu.unicauca.parcial.services.mapper.curso;

import co.edu.unicauca.parcial.models.Curso;
import co.edu.unicauca.parcial.services.DTO.CursoDTO;
import co.edu.unicauca.parcial.services.mapper.Simple;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CursoMapper {

    @Simple
    @Mapping(target = "asignatura.id", source = "asignatura.id")
    @Mapping(target = "asignatura.nombre", source = "asignatura.nombre")
    @Mapping(target = "asignatura.cursos", ignore = true)
    @Mapping(target = "asignatura.docentes", ignore = true)
    CursoDTO entityToDto(Curso entity);

    @Mapping(target = "asignatura.cursos", ignore = true)
    @Mapping(target = "asignatura.docentes", ignore = true)
    Curso dtoToEntity(CursoDTO dto);

    @IterableMapping(qualifiedBy = Simple.class)
    List<CursoDTO> entityListToDtoListCurso(List<Curso> entityList);
}
