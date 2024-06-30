package com.cibertec.tareas.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.tareas.entity.Usuario;
import com.cibertec.tareas.repository.UsuarioRepository;



@Service
public class UsuarioService extends ICRUDImpl<Usuario,Integer> {
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public JpaRepository<Usuario, Integer> getRepository() {
		
		return repo;
	}
}