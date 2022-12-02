package co.edu.unicauca.parcial.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
public class Estudiante extends Persona{
    @Column(nullable = false)
    private Date fechaIngreso;

    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "estudiante") //eager
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "estudiante") //lazy
    private List<Telefono> telefonos;

    //@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "idEstudiante")//eager
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "idEstudiante") //lazy
    private Direccion direccion;
}
