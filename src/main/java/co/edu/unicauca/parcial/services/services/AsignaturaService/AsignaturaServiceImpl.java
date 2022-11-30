package co.edu.unicauca.parcial.services.services.AsignaturaService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.parcial.models.Asignatura;
import co.edu.unicauca.parcial.models.Curso;
import co.edu.unicauca.parcial.models.Docente;
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
    public AsignaturaDTO createAsignatura(AsignaturaDTO asignatura) {
        System.out.println("Invocando al metodo crear asignatura");
        Asignatura objAsignatura = modelMapper.map(asignatura, Asignatura.class);
        objAsignatura.getCursos().forEach(c -> c.setObjAsignatura(objAsignatura));
        objAsignatura.getDocentes().forEach(d -> d.getAsignaturas().add(objAsignatura));
        Asignatura asignatura2 = asignaturaRepository.save(objAsignatura);
        return modelMapper.map(asignatura2, AsignaturaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaDTO> getAllAsignaturas() {
        System.out.println("Invocando al metodo buscar todas las asignaturas");
        Iterable<Asignatura> asignaturas = asignaturaRepository.findAll();
        List<AsignaturaDTO> asignaturasDTO = modelMapper.map(
                asignaturas, new TypeToken<List<AsignaturaDTO>>() {
                }.getType());
        return asignaturasDTO;
    }

    @Override
    public AsignaturaDTO getAsignaturaById(Integer id) {
        System.out.println("Invocando al metodo buscar asignatura por id");
        Asignatura asignatura = asignaturaRepository.findById(id).orElse(null);
        AsignaturaDTO asignaturaDTO = modelMapper.map(asignatura, AsignaturaDTO.class);
        return asignaturaDTO;
    }

    @Override
    public AsignaturaDTO updateAsignatura(Integer id, AsignaturaDTO asignatura) {
        System.out.println("Invocando al metodo actualizar asignatura");
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
            objAsignatura.getCursos().forEach(c -> c.setObjAsignatura(objAsignatura));
            objAsignatura.getDocentes().forEach(d -> d.getAsignaturas().add(objAsignatura));
            Asignatura asignaturaModificada = asignaturaRepository.save(objAsignatura);
            asignaturaDTO = modelMapper.map(asignaturaModificada, AsignaturaDTO.class);
        }

        return asignaturaDTO;
    }

    @Override
    public boolean deleteAsignatura(Integer id) {
        System.out.println("Invocando al metodo eliminar asignatura");
        boolean result = false;
        Asignatura asignatura = asignaturaRepository.findById(id).orElse(null);
        if (asignatura != null) {
            asignaturaRepository.delete(asignatura);
            result = true;
        }
        return result;
    }

}