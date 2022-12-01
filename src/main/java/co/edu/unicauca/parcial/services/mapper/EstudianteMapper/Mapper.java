package co.edu.unicauca.parcial.services.mapper.EstudianteMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.parcial.models.Estudiante;
import co.edu.unicauca.parcial.services.DTO.EstudianteDTO;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapperEstudiante(){
        ModelMapper objMapper = new ModelMapper();
        
        //TypeMap<Estudiante, EstudianteDTO> mapa = objMapper.emptyTypeMap(Estudiante.class, EstudianteDTO.class);
        return objMapper;
    }
}
