package co.edu.unicauca.parcial.services.services.DocenteService;

import co.edu.unicauca.parcial.models.Docente;
import co.edu.unicauca.parcial.services.DTO.DocenteDTO;

import java.util.List;

public interface IDocenteService {
    public DocenteDTO createDocente(DocenteDTO docente);

    public List<DocenteDTO> getAllDocente();

    public Docente getDocenteBDocente(Integer id);

    public DocenteDTO upDocenteDTO(Integer id, DocenteDTO docente);

    public boolean deleteDocente(int id);
}
