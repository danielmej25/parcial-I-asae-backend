package co.edu.unicauca.parcial.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "direccion")
@Getter
@Setter
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_persona")
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Estudiante idEstudiante;

    @Column(length = 30, nullable = false)
    private String direccionResidencia;

    @Column(length = 30, nullable = false)
    private String ciudad;

    @Column(length = 30, nullable = false)
    private String pais;





}
