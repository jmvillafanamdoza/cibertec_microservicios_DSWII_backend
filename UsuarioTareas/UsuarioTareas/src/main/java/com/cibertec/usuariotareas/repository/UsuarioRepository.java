package com.cibertec.usuariotareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.usuariotareas.entity.Rol;
import com.cibertec.usuariotareas.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {

    @Query("Select x from Usuario x where x.login = :#{#usu.login} and x.password = :#{#usu.password}")
    public abstract Usuario login(@Param(value = "usu") Usuario bean);

    @Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.idUsuario = ?1 ")
    public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

    public abstract Usuario findByLogin(String login);

}
