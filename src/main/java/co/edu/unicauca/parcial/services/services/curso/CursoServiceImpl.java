package co.edu.unicauca.parcial.services.services.curso;

import java.util.List;

import co.edu.unicauca.parcial.models.Asignatura;
import co.edu.unicauca.parcial.models.Curso;
import co.edu.unicauca.parcial.repositories.AsignaturaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.parcial.repositories.CursoRepository;
import co.edu.unicauca.parcial.services.DTO.CursoDTO;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    @Qualifier("curso")
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CursoDTO> getAllCursos() {
        Iterable<Curso> cursos = cursoRepository.findAll();
        return modelMapper.map(cursos, new TypeToken<List<CursoDTO>>() {
        }.getType());
    }

    @Override
    @Transactional()
    public CursoDTO createCurso(CursoDTO cursoDTO) {
        Curso objCurso = modelMapper.map(cursoDTO, Curso.class);
        Asignatura asignatura = asignaturaRepository.findById(cursoDTO.getObjAsignatura().getId()).orElse(null);
        if (asignatura == null){
            //TODO respond with e.g. 400 "bad request
            return null;
        }
        objCurso.setAsignatura(asignatura);
        return modelMapper.map(cursoRepository.save(objCurso), CursoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public CursoDTO getCursoById(Integer id) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        return modelMapper.map(curso, CursoDTO.class);
    }

    @Override
    @Transactional(readOnly = false)
    public CursoDTO updateCurso(Integer id, CursoDTO curso) {
        Curso objCurso = cursoRepository.findById(id).orElse(null);
        CursoDTO cursoDTO = null;
        if (objCurso != null) {
            objCurso.setNombre(curso.getNombre());
            objCurso.setPeriodo(curso.getPeriodo());
            objCurso.setAsignatura(objCurso.getAsignatura());
            objCurso = cursoRepository.save(objCurso);
            cursoDTO = modelMapper.map(objCurso, CursoDTO.class);
        }

        return cursoDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean deleteCurso(Integer id) {
        boolean result = false;
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso != null) {
            cursoRepository.delete(curso);
            result = true;
        }
        return result;
    }

}
