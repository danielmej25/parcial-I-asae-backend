package co.edu.unicauca.parcial.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objAsignatura", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "docentes_asignaturas", 
        joinColumns = @JoinColumn(name = "id_asignatura"), 
        inverseJoinColumns = @JoinColumn(name = "id_persona"))
    private List<Docente> docentes;
}