package co.edu.unicauca.parcial.services.services.asignatura;

import java.util.List;

import co.edu.unicauca.parcial.models.Asignatura;
import co.edu.unicauca.parcial.models.Curso;
import co.edu.unicauca.parcial.models.Docente;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.parcial.repositories.AsignaturaRepository;
import co.edu.unicauca.parcial.services.DTO.AsignaturaDTO;

@Service
public class AsignaturaServiceImpl implements IAsignturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    @Qualifier("asignatura")
    private ModelMapper modelMapper;

    @Override
    @Transactional()
    public AsignaturaDTO createAsignatura(AsignaturaDTO asignaturaDTO) {
        Asignatura objAsignatura = modelMapper.map(asignaturaDTO, Asignatura.class);
        if (objAsignatura.getCursos() != null){
            objAsignatura.getCursos().forEach(c -> c.setAsignatura(objAsignatura));
        }else{
            //TODO respond with e.g. 400 "bad request
            return null;
        }
        if (objAsignatura.getDocentes() != null){
            objAsignatura.getDocentes().forEach(d -> d.getAsignaturas().add(objAsignatura));
        }else{
            //TODO respond with e.g. 400 "bad request
            //return null;
        }
        Asignatura asignatura2 = asignaturaRepository.save(objAsignatura);
        return modelMapper.map(asignatura2, AsignaturaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaDTO> getAllAsignaturas() {
        Iterable<Asignatura> asignaturas = asignaturaRepository.findAll();
        return modelMapper.map(
                asignaturas, new TypeToken<List<AsignaturaDTO>>() {
                }.getType());
    }

    @Override
    public AsignaturaDTO getAsignaturaById(Integer id) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElse(null);
        return modelMapper.map(asignatura, AsignaturaDTO.class);
    }

    @Override
    public AsignaturaDTO updateAsignatura(Integer id, AsignaturaDTO asignatura) {
        Asignatura objAsignatura = asignaturaRepository.findById(id).orElse(null);
        AsignaturaDTO asignaturaDTO = null;

        if (objAsignatura != null) {
            objAsignatura.setNombre(asignatura.getNombre());
            List<Curso> cursos = modelMapper.map(asignatura.getCursos(), new TypeToken<List<Curso>>() {
            }.getType());
            List<Docente> docentes = modelMapper.map(asignatura.getDocentes(), new TypeToken<List<Docente>>() {
            }.getType());
            objAsignatura.setCursos(cursos);
            objAsignatura.setDocentes(docentes);
            objAsignatura.getCursos().forEach(c -> c.setAsignatura(objAsignatura));
            objAsignatura.getDocentes().forEach(d -> d.getAsignaturas().add(objAsignatura));
            Asignatura asignaturaModificada = asignaturaRepository.save(objAsignatura);
            asignaturaDTO = modelMapper.map(asignaturaModificada, AsignaturaDTO.class);
        }

        return asignaturaDTO;
    }

    @Override
    public boolean deleteAsignatura(Integer id) {
        boolean result = false;
        Asignatura asignatura = asignaturaRepository.findById(id).orElse(null);
        if (asignatura != null) {
            asignaturaRepository.delete(asignatura);
            result = true;
        }
        return result;
    }

}
