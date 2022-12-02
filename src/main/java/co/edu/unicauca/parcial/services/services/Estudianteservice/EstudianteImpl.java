package co.edu.unicauca.parcial.services.services.Estudianteservice;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.parcial.models.Estudiante;
import co.edu.unicauca.parcial.repositories.EstudianteRepository;
import co.edu.unicauca.parcial.services.DTO.EstudianteDTO;


@Service
public class EstudianteImpl implements IEstudianteService{

    //TODO: por que no funciona el mapper creado estudiante mapper?
    //TODO: no se puede crear mas mapper? toca hacer todo des
    @Autowired
    @Qualifier("estudiante")
    private ModelMapper mapper;

    @Autowired
    @Qualifier("estudianteLazy")
    private ModelMapper mapperLazy;

    /*
    @Autowired
    @Qualifier("estudianteLazyOtro")
    private ModelMapper mapperLazyOtro;*/

    @Autowired
    EstudianteRepository accesoDatos;

    @Override
    public List<EstudianteDTO> getAll(){
        Iterable<Estudiante> estudiantes = accesoDatos.findAll();
        List<EstudianteDTO> estudiantesDTO = mapper.map(estudiantes, new TypeToken<List<EstudianteDTO>>(){}.getType());
        return estudiantesDTO;
    }

    @Override
    public EstudianteDTO getById(Integer id){
        Optional<Estudiante> estudiante = accesoDatos.findById(id);
        System.out.println(estudiante.get().getNombres());
        EstudianteDTO estudianteDTO = mapper.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;
    }

    
    @Override
    public List<EstudianteDTO> getAllLazy(){
        Iterable<Estudiante> estudiantes = accesoDatos.findAll();
        List<EstudianteDTO> estudiantesDTO = mapperLazy.map(estudiantes, new TypeToken<List<EstudianteDTO>>(){}.getType());
        return estudiantesDTO;
    }

    @Override
    public EstudianteDTO getByIdLazy(Integer id){
        Optional<Estudiante> estudiante = accesoDatos.findById(id);
        EstudianteDTO estudianteDTO = mapperLazy.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;
    }
}
