package com.cibertec.tareas.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cibertec.tareas.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaDTO {
	private Integer id;
	@NotNull
	private String titulo;
	@NotNull
	private String descripcion;
	@NotNull
	private String estado;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaVencimiento;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaCreacion;
    
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
}
