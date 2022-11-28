package co.edu.unicauca.parcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/estudiantes")
    public List<EstudianteDTO> index(){
        return service.getAll();
    }

    @GetMapping("/estudiantes/{id}")
    public EstudianteDTO show(@PathVariable Integer id){
        return service.getById(id);
    }
}
