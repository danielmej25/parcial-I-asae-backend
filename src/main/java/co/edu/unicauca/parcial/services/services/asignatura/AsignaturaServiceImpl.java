package co.edu.unicauca.parcial.services.services.asignatura;

import java.util.List;

import co.edu.unicauca.parcial.models.Asignatura;
import co.edu.unicauca.parcial.repositories.AsignaturaRepository;
import co.edu.unicauca.parcial.services.DTO.AsignaturaDTO;
import co.edu.unicauca.parcial.services.mapper.asignatura.AsignaturaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AsignaturaServiceImpl implements IAsignturaService {

    private final AsignaturaRepository asignaturaRepository;
    private final AsignaturaMapper asignaturaMapper;

    @Override
    @Transactional()
    public AsignaturaDTO createAsignatura(AsignaturaDTO asignatura) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaDTO> getAllAsignaturas() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        return asignaturaMapper.entityToDto(asignaturas);
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
