package com.cibertec.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.tareas.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
}
