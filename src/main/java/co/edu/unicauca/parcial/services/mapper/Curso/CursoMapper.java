package co.edu.unicauca.parcial.services.mapper.Curso;

import co.edu.unicauca.parcial.models.Curso;
import co.edu.unicauca.parcial.services.DTO.CursoDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CursoMapper {

    @Simple
    @Mapping(target = "asignaturaDTO.id", source = "asignatura.id")
    @Mapping(target = "asignaturaDTO.nombre", source = "asignatura.nombre")
    @Mapping(target = "asignaturaDTO.cursoDTOS", ignore = true)
    @Mapping(target = "asignaturaDTO.docenteDTOS", ignore = true)
    CursoDTO entityToDto(Curso entity);

    @Mapping(target = "asignatura", source = "asignaturaDTO")
    @Mapping(target = "asignatura.cursos", ignore = true)
    @Mapping(target = "asignatura.docentes", ignore = true)
    Curso DtoToEntity(CursoDTO dto);

    @IterableMapping(qualifiedBy = Simple.class)
    List<CursoDTO> entityListToDtoList(List<Curso> entityList);
}
