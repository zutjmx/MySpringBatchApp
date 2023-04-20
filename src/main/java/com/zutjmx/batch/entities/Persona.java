package com.zutjmx.batch.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(name = "apellido_paterno")
    private String aPaterno;

    @Column(name = "apellido_materno")
    private String aMaterno;
    private String email;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
}
