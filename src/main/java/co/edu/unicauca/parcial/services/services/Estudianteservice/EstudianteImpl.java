package co.edu.unicauca.parcial.services.services.Estudianteservice;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.parcial.models.Estudiante;
import co.edu.unicauca.parcial.repositories.EstudianteRepository;
import co.edu.unicauca.parcial.services.DTO.EstudianteDTO;


@Service
public class EstudianteImpl implements IEstudianteService{
  
    @Autowired
    private ModelMapper mapper;

    @Autowired
    EstudianteRepository accesoDatos;
    @Override
    @Transactional
    public EstudianteDTO save(EstudianteDTO estudiante) {
        EstudianteDTO  estudianteDTO = null;
        
        System.out.println("invocando al metodo crear estudiante");
        Estudiante objEstudiante = this.mapper.map(estudiante,Estudiante.class);

        //Preguntar profeso
        objEstudiante.getTelefonos().forEach(telefono -> telefono.setEstudiante(objEstudiante));
        objEstudiante.getDireccion().setIdEstudiante(objEstudiante);

        Estudiante estudianteEntity = this.accesoDatos.save(objEstudiante);
        estudianteDTO = this.mapper.map(estudianteEntity, EstudianteDTO.class);
        return estudianteDTO;
    }


    @Override
	@Transactional(readOnly = false)
	public EstudianteDTO update(Integer id, EstudianteDTO objEstudianteConDatosNuevos) {
		/*Optional<Estudiante> optional = this.accesoDatos.findById(id);
		EstudianteDTO estudianteDTOActualizado = null;
		Estudiante objEstudianteAlmacenado = optional.get();

		if (objEstudianteAlmacenado != null) {
			objEstudianteAlmacenado.setId(objEstudianteConDatosNuevos.getId());
			objEstudianteAlmacenado.setNombres(objEstudianteConDatosNuevos.getNombres());
			objEstudianteAlmacenado.setApellidos(objEstudianteConDatosNuevos.getApellidos());
			objEstudianteAlmacenado.setNoId(objEstudianteConDatosNuevos.getNoId());
            objEstudianteAlmacenado.setTipoIdentificacion(objEstudianteConDatosNuevos.getTipoIdentificacion());
			Direccion objDireccionAlmacenada = objEstudianteAlmacenado.getDireccion();
			objDireccionAlmacenada.setDireccionResidencia(objEstudianteConDatosNuevos.getDireccion().getDireccionResidencia());
			objDireccionAlmacenada.setCiudad(objEstudianteConDatosNuevos.getDireccion().getCiudad());
			objDireccionAlmacenada.setPais(objEstudianteAlmacenado.getDireccion().getPais());
		    List<Telefono> ObjTelefonoAlmacenado = objEstudianteConDatosNuevos.getTelefonos();
            for(int i=0;i<objEstudianteConDatosNuevos.getTelefonos().size();i++)
            {
                ObjTelefonoAlmacenado.get(i).setNumero(objEstudianteConDatosNuevos.getTelefonos().get(i).getTipo());
                ObjTelefonoAlmacenado.get(i).setNumero(objEstudianteConDatosNuevos.getTelefonos().get(i).getNumero());
            }
            
			Estudiante estudianteEntityActualizado = this.accesoDatos.save(objEstudianteAlmacenado);
			estudianteDTOActualizado = this.mapper.map(estudianteEntityActualizado, EstudianteDTO.class);
		}
		return estudianteDTOActualizado;*/
        return null;
	}

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
}
