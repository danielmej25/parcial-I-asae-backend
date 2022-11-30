package co.edu.unicauca.parcial.repositories;

import co.edu.unicauca.parcial.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
    
}
