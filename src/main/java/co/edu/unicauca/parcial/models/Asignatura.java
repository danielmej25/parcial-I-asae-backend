package co.edu.unicauca.parcial.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "asignatura")
@Getter
@Setter
public class Asignatura implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private int id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<Curso> cursos;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "asignaturas")
    private List<Docente> docentes;
}
