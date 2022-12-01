package co.edu.unicauca.parcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.parcial.services.DTO.EstudianteDTO;
import co.edu.unicauca.parcial.services.services.Estudianteservice.IEstudianteService;

@RestController
@RequestMapping("/api")
@Validated
public class EstudianteRestController {
    @Autowired
    private IEstudianteService service;

    @PostMapping("/estudiantes")
    public EstudianteDTO create(@RequestBody EstudianteDTO estudiante){
        EstudianteDTO objEstudiante = null;
        objEstudiante = service.save(estudiante);
        return objEstudiante;
    }

    @PutMapping("/clientes/{id}")
	public EstudianteDTO update(@RequestBody EstudianteDTO cliente, @PathVariable Integer id) {
		EstudianteDTO objEstudiante = null;
		System.out.println("actualizando Estudiante");
		EstudianteDTO estudianteActual = service.getById(id);
		if (estudianteActual != null) {
			objEstudiante = service.update(id, cliente);
		}
		return objEstudiante;
	}

    @GetMapping("/estudiantes")
    public List<EstudianteDTO> index(){
        return service.getAll();
    }

    @GetMapping("/estudiantes/{id}")
    public EstudianteDTO show(@PathVariable Integer id){
        return service.getById(id);
    }
}
