package co.edu.unicauca.parcial.services.services.Estudianteservice;

import java.util.List;

import co.edu.unicauca.parcial.services.DTO.EstudianteDTO;

public interface IEstudianteService {
    public List<EstudianteDTO> getAll();
    public EstudianteDTO getById();
}
