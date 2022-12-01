package co.edu.unicauca.parcial.services.mapper.curso;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CursoMapper {
    @Bean(name = "curso")
    public ModelMapper cursoMapper(){
        ModelMapper objMapper = new ModelMapper();
        return objMapper;
    }
}
