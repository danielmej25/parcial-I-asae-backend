package co.edu.unicauca.parcial.services.mapper.EstudianteMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper(); 
        return modelMapper;
    }
}
