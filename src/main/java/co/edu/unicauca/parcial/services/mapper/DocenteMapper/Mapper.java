package co.edu.unicauca.parcial.services.mapper.DocenteMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.parcial.models.Docente;
import co.edu.unicauca.parcial.services.DTO.AsignaturaDTO;
import co.edu.unicauca.parcial.services.DTO.DocenteDTO;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper docenentMapper(){
        ModelMapper objMapper = new ModelMapper();
        // TypeMap<Docente,DocenteDTO> mapa = objMapper.emptyTypeMap(
        //     Docente.class, DocenteDTO.class);

        // //mapa.addMappings(doc -> doc.skip(DocenteDTO::setId)).implicitMappings();
        // //mapa.addMappings(doc -> doc.skip(DocenteDTO::setApellidos)).implicitMappings();
        // mapa.addMappings(doc -> doc.skip(DocenteDTO::setAsignaturas)).implicitMappings();
        // //mapa.addMappings(doc -> doc.skip(DocenteDTO::setNoId)).implicitMappings();
        // //mapa.addMappings(doc -> doc.skip(DocenteDTO::setNombres)).implicitMappings();
        // //mapa.addMappings(doc -> doc.skip(DocenteDTO::setSalario)).implicitMappings();
        // //mapa.addMappings(doc -> doc.skip(DocenteDTO::setTipoDocente)).implicitMappings();
        // //mapa.addMappings(doc -> doc.skip(DocenteDTO::setTipoIdentificacion)).implicitMappings();
        // //mapa.addMappings(doc -> doc.skip(DocenteDTO::setUniversidad)).implicitMappings();
    return objMapper;
    }
}
