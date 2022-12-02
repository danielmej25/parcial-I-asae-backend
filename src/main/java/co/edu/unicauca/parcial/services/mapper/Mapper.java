package co.edu.unicauca.parcial.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.parcial.models.Estudiante;
import co.edu.unicauca.parcial.services.DTO.EstudianteDTO;

@Configuration
public class Mapper {
    @Bean(name="estudiante")
    public ModelMapper modelMapperEstudiante(){
        ModelMapper objMapper = new ModelMapper();
        TypeMap<Estudiante, EstudianteDTO> mapa = objMapper.getTypeMap(Estudiante.class, EstudianteDTO.class);
        return objMapper;
    }
    
    @Bean(name="estudianteLazy")
    public ModelMapper modelMapperEstudianteLazy(){
        ModelMapper objMapper = new ModelMapper();
        //TypeMap<Estudiante, EstudianteDTO> mapa = objMapper.emptyTypeMap(Estudiante.class, EstudianteDTO.class); 
        TypeMap<Estudiante, EstudianteDTO> mapa = objMapper.emptyTypeMap(Estudiante.class, EstudianteDTO.class);
        /*
        TypeMap<ClienteEntity, ClienteDTO> mapa = objMapper.emptyTypeMap(ClienteEntity.class, ClienteDTO.class);
        // mapa.addMappings(n ->
        // n.skip(ClienteDTO::setObjDireccion)).implicitMappings();
        mapa.addMappings(m -> m.skip(ClienteDTO::setSolicitudes)).implicitMappings();
         */
        mapa.addMappings(m -> m.skip(EstudianteDTO::setDireccion)).implicitMappings();
        mapa.addMappings(m -> m.skip(EstudianteDTO::setTelefonos)).implicitMappings();
        return objMapper;
    }

    /*
    @Bean(name="estudianteLazyOtro")
    public ModelMapper modelMapperEstudianteLazyOtro(){
        ModelMapper objMapper = new ModelMapper();
        TypeMap<Estudiante, EstudianteDTO> mapa = objMapper.emptyTypeMap(Estudiante.class, EstudianteDTO.class);
        return objMapper;
    }
    */
}
