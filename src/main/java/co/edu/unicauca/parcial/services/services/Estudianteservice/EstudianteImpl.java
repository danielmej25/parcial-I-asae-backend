package co.edu.unicauca.parcial.services.services.Estudianteservice;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.parcial.models.Estudiante;
import co.edu.unicauca.parcial.repositories.EstudianteRepository;
import co.edu.unicauca.parcial.services.DTO.EstudianteDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudianteImpl implements IEstudianteService{

    //TODO: por que no funciona el mapper creado estudiante mapper?
    //TODO: no se puede crear mas mapper? toca hacer todo des
    @Autowired
    private ModelMapper mapper;

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
        EstudianteDTO estudianteDTO = mapper.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        System.out.println("invocando al metodo eliminar estudiante");
        java.util.Optional<Estudiante> optional=this. accesoDatos.findById(id);
        boolean bandera = false;

        if (optional.isPresent()) {
            this. accesoDatos.deleteById(id);
            System.out.println("Estudiante eliminado");
            bandera = true;            
        }
        else
        {
            System.out.println("Estudiante No encontrado");
        }
        return bandera;
    } 
}
