package com.cibertec.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.tareas.entity.Tareas;



public interface TareaRepository extends JpaRepository<Tareas,Integer> {

}
