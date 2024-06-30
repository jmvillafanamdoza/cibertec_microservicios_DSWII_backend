package com.cibertec.usuariotareas.service;


import java.util.List;

import com.cibertec.usuariotareas.entity.Rol;
import com.cibertec.usuariotareas.entity.Usuario;


public interface UsuarioService {


    public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

    public abstract Usuario buscaPorLogin(String login);
}
