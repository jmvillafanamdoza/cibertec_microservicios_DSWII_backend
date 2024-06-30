package com.cibertec.tareas.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.tareas.entity.Tareas;
import com.cibertec.tareas.repository.TareaRepository;

@Service
public class TareaService extends ICRUDImpl<Tareas,Integer> {
	@Autowired
	private TareaRepository repo;
	
	@Override
	public JpaRepository<Tareas, Integer> getRepository() {
		return repo;
	}
}
