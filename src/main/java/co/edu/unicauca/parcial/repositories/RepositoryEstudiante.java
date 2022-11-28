package co.edu.unicauca.parcial.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.parcial.models.Estudiante;

//Teniendo en cuenta la herencia de persona a estudiante, el identificador es el Integer idPersona
public interface RepositoryEstudiante extends CrudRepository<Estudiante, Integer>{
    
}
