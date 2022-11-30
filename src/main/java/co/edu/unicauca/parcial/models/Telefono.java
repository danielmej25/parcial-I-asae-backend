package co.edu.unicauca.parcial.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefono")
@Getter
@Setter
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefono")
    private int id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Estudiante estudiante;
}
