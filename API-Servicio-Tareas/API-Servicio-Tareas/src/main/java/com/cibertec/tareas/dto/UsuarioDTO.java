package com.cibertec.tareas.dto;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDTO {
	private Integer id;
	@NotNull
	private String nombre;
	@NotNull
	private String email;
	@NotNull
	private String contraseña;

	 @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaCreacion;
}