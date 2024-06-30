package com.cibertec.usuariotareas.service;

import com.cibertec.usuariotareas.entity.Rol;
import com.cibertec.usuariotareas.entity.Usuario;
import com.cibertec.usuariotareas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Rol> traerRolesDeUsuario(int idUsuario) {
        return repository.traerRolesDeUsuario(idUsuario);
    }

    @Override
    public Usuario buscaPorLogin(String login) {
        return repository.findByLogin(login);
    }
}
