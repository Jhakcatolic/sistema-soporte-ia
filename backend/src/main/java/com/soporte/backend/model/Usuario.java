package com.soporte.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_id_usuario_seq", allocationSize = 1)
    
    private Long id_usuario;

    private String nombre;
    private String email;
    private String password;

    private Integer id_rol;
}
