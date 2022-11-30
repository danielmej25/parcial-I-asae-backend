package co.edu.unicauca.parcial.services.services.Asignatura;

import java.util.List;

import co.edu.unicauca.parcial.models.Asignatura;
import co.edu.unicauca.parcial.models.Curso;
import co.edu.unicauca.parcial.models.Docente;
import co.edu.unicauca.parcial.repositories.AsignaturaRepository;
import co.edu.unicauca.parcial.services.DTO.AsignaturaDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AsignaturaServiceImpl implements IAsignturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    @Transactional()
    public AsignaturaDTO createAsignatura(AsignaturaDTO asignatura) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaDTO> getAllAsignaturas() {
        return null;
    }

    @Override
    public AsignaturaDTO getAsignaturaById(Integer id) {
        return null;
    }

    @Override
    public AsignaturaDTO updateAsignatura(Integer id, AsignaturaDTO asignatura) {
        return null;
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
