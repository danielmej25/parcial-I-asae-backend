package co.edu.unicauca.parcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import co.edu.unicauca.parcial.models.Docente;
import co.edu.unicauca.parcial.services.DTO.DocenteDTO;
import co.edu.unicauca.parcial.services.services.DocenteService.IDocenteService;

@RestController
@RequestMapping("/api")
@Validated
public class DocenteRestController {
    @Autowired
    private IDocenteService docenteService;

    @PostMapping("/docentes")
    public DocenteDTO create(@RequestBody DocenteDTO docente){
        DocenteDTO docenteDTO = null;
        docenteDTO = docenteService.createDocente(docente);
        return docenteDTO;
    }
    @GetMapping("/docentes")
	public List<DocenteDTO> index() {
		return docenteService.getAllDocente();
	}

}
