package com.cibertec.usuariotareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.usuariotareas.entity.UsuarioHasRol;
import com.cibertec.usuariotareas.entity.UsuarioHasRolPK;

public interface UsuarioTieneRolRepository extends JpaRepository<UsuarioHasRol, UsuarioHasRolPK>{

}
