package co.edu.unicauca.parcial.services.mapper.asignatura;

import co.edu.unicauca.parcial.models.Asignatura;
import co.edu.unicauca.parcial.services.DTO.AsignaturaDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsignaturaMapper {
    @Bean(name = "asignatura")
    public ModelMapper asignaturaMapper(){
        ModelMapper objMapper = new ModelMapper();
        TypeMap<Asignatura,AsignaturaDTO> mapa = objMapper.emptyTypeMap(Asignatura.class, AsignaturaDTO.class);
        mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setDocentes)).implicitMappings();
        return objMapper;
    }
}
