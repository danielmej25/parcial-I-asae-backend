package co.edu.unicauca.parcial.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id;

    @Column(name = "no_identificacion", nullable = false)
    private String noId;

    @Column(nullable = false, length = 30)
    private String numeroIdentificacion;

    @Column(nullable = false, length = 30)
    private String nombres;

    @Column(nullable = false, length = 30)
    private String apellidos;
}
