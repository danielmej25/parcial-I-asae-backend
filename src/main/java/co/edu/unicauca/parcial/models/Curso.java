package co.edu.unicauca.parcial.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "curso")
@Getter
@Setter
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int periodo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;
}
