package co.edu.unicauca.parcial.services.services.asignatura;

import co.edu.unicauca.parcial.services.DTO.AsignaturaDTO;

import java.util.List;

public interface IAsignturaService {
    public AsignaturaDTO createAsignatura(AsignaturaDTO asignatura);

    public List<AsignaturaDTO> getAllAsignaturas();

    public AsignaturaDTO getAsignaturaById(Integer id);

    public AsignaturaDTO updateAsignatura(Integer id, AsignaturaDTO asignatura);

    public boolean deleteAsignatura(Integer id);
}
