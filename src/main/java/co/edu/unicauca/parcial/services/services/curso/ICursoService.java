package co.edu.unicauca.parcial.services.services.curso;

import co.edu.unicauca.parcial.services.DTO.CursoDTO;

import java.util.List;


public interface ICursoService {
    public CursoDTO createCurso(CursoDTO curso);

    public CursoDTO getCursoById(Integer id);

    public CursoDTO updateCurso(Integer id, CursoDTO curso);

    public boolean deleteCurso(Integer id);

    public List<CursoDTO> getAllCursos();
}
