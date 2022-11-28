package co.edu.unicauca.parcial.services.services.Estudianteservice;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.parcial.models.Estudiante;
import co.edu.unicauca.parcial.services.DTO.EstudianteDTO;

@Service
public class EstudianteImpl implements IEstudianteService{
    
    @Override
    public List<EstudianteDTO> getAll(){
        
    }

    @Override
    public EstudianteDTO getById(){
        return null;
    }
}
