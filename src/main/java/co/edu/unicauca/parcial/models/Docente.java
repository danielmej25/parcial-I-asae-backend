package co.edu.unicauca.parcial.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "docente")
@Getter
@Setter
public class Docente extends Persona{
    @Column(nullable = false)
    private String universidad;

    @Column(name = "tipo_docente",nullable = false)
    private String tipoDocente;

    @Column(nullable = false)
    private float salario;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "docentes_asignaturas",
            joinColumns = @JoinColumn(name = "id_persona"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
    private List<Asignatura> asignaturas;
}
