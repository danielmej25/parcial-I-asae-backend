package co.edu.unicauca.parcial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.parcial.services.DTO.AsignaturaDTO;
import co.edu.unicauca.parcial.services.services.asignatura.IAsignturaService;

@RestController
@RequestMapping("/api")
@Validated
public class AsignaturaRestController {

    @Autowired
    private IAsignturaService asignaturaService;

    @GetMapping("/asignaturas")
    public List<AsignaturaDTO> index() {
        return asignaturaService.getAllAsignaturas();
    }

    @GetMapping("/asignaturas/{id}")
    public AsignaturaDTO show(@PathVariable Integer id) {
        return asignaturaService.getAsignaturaById(id);
    }

    @PostMapping("/asignaturas")
    public AsignaturaDTO create(@Valid @RequestBody AsignaturaDTO asignatura) {
        AsignaturaDTO asignaturaDTO = null;
        asignaturaDTO = asignaturaService.createAsignatura(asignatura);
        return asignaturaDTO;
    }

    @PutMapping("/asignaturas")
    public AsignaturaDTO update(@Valid @RequestBody AsignaturaDTO asignatura, @PathVariable Integer id) {
        AsignaturaDTO asignaturaDTO = null;
        AsignaturaDTO asignaturaActual = asignaturaService.getAsignaturaById(id);
        
        if (asignaturaActual != null) {
            asignaturaDTO = asignaturaService.updateAsignatura(id, asignaturaDTO);
        }

        return asignaturaDTO;
    }

    @DeleteMapping("/asignaturas/{id}")
    public boolean delete(@PathVariable Integer id) {
        boolean result = false;
        AsignaturaDTO asignaturaActual = asignaturaService.getAsignaturaById(id);
        if (asignaturaActual != null) {
            result = asignaturaService.deleteAsignatura(id);
        }
        return result;
    }

}