package co.edu.unicauca.parcial.controller;

import co.edu.unicauca.parcial.services.DTO.AsignaturaDTO;
import co.edu.unicauca.parcial.services.services.asignatura.IAsignturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AsignaturaRestController {

    @Autowired
    private IAsignturaService asignaturaService;

    @GetMapping("/asignaturas")
    public List<AsignaturaDTO> index() {
        List<AsignaturaDTO> asignaturas = asignaturaService.getAllAsignaturas();
        return asignaturas;
    }

    @GetMapping("/asignaturas/{id}")
    public AsignaturaDTO show(@PathVariable Integer id) {
        AsignaturaDTO asignatura = asignaturaService.getAsignaturaById(id);
        return asignatura;
    }

    @PostMapping("/asignaturas")
    public AsignaturaDTO create(@RequestBody AsignaturaDTO asignatura) {
        AsignaturaDTO asignaturaDTO = null;
        asignaturaDTO = asignaturaService.createAsignatura(asignatura);
        return asignaturaDTO;
    }

    @PutMapping("/asignaturas")
    public AsignaturaDTO update(@RequestBody AsignaturaDTO asignatura, @PathVariable Integer id) {
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
