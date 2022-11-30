package co.edu.unicauca.parcial.services.services.Curso;

import java.util.List;

import co.edu.unicauca.parcial.models.Curso;
import co.edu.unicauca.parcial.repositories.AsignaturaRepository;
import co.edu.unicauca.parcial.repositories.CursoRepository;
import co.edu.unicauca.parcial.services.DTO.CursoDTO;
import co.edu.unicauca.parcial.services.mapper.Curso.CursoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CursoServiceImpl implements ICursoService {

    private final CursoRepository cursoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final CursoMapper cursoMapper;

    @Override
    @Transactional()
    public CursoDTO createCurso(CursoDTO cursoDTO) {
        Curso curso = cursoMapper.DtoToEntity(cursoDTO);
        return cursoMapper.entityToDto(cursoRepository.save(curso));
    }

    @Override
    @Transactional(readOnly = true)
    public CursoDTO getCursoById(Integer id) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        return cursoMapper.entityToDto(curso);

    }

    @Override
    @Transactional(readOnly = false)
    public CursoDTO updateCurso(Integer id, CursoDTO curso) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean deleteCurso(Integer id) {
        System.out.println("Invocando al metodo eliminar curso por id: " + id);
        boolean result = false;
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso != null) {
            cursoRepository.delete(curso);
            result = true;
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CursoDTO> getAllCursos() {

        return cursoMapper.entityListToDtoList(cursoRepository.findAll());
    }

}
