package com.cibertec.tareas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.tareas.dto.TareaDTO;
import com.cibertec.tareas.entity.Tareas;
import com.cibertec.tareas.serviceImpl.TareaService;
import com.cibertec.tareas.utils.MensajeResponse;
import com.cibertec.tareas.utils.ModeloNotFoundException;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class TareaController {
	
	@Autowired
	private TareaService servicioTarea;
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")							
	public ResponseEntity<?> listar(){
		List<Tareas>lista=servicioTarea.listarTodos();
		if(lista==null) {
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje("No hay registros por ahora")
					.object(null).build(),HttpStatus.OK);
		}
		else {
			List<TareaDTO> data=lista.stream().map(m->   
				mapper.map(m, TareaDTO.class)).collect(Collectors.toList());
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje("Registros Actuales")
					.object(data).build(),HttpStatus.OK);		
		}
		
	}

	@PostMapping("/crear")
	public  ResponseEntity<?>  grabar(@Valid @RequestBody TareaDTO bean){
		try {
			Tareas tarea=mapper.map(bean, Tareas.class);
			Tareas t=servicioTarea.registrar(tarea);
			TareaDTO dto=mapper.map(t, TareaDTO.class);
			
			return new ResponseEntity<>(MensajeResponse.builder()
						.mensaje("Guardado correctamente")
						.object(dto).build(),HttpStatus.CREATED);	
		} catch (Exception e) {
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje(e.getMessage())
					.object(null).build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@Valid @RequestBody TareaDTO bean){

		Tareas tareaBuscar=servicioTarea.buscarPorID(bean.getId());

		if(tareaBuscar==null)
			throw new ModeloNotFoundException("Còdigo de la Tarea : "+bean.getId()+" no existe");
		else {
			Tareas tarea=mapper.map(bean, Tareas.class);
			Tareas t=servicioTarea.actualizar(tarea);
			TareaDTO dto=mapper.map(t, TareaDTO.class);
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje("Registro actualizado")
					.object(dto).build(),HttpStatus.OK);
		}
		
	}
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		Tareas tareaBuscar=servicioTarea.buscarPorID(id);
		if(tareaBuscar==null)
			throw new ModeloNotFoundException("Còdigo de la Tarea : "+id+" no existe");
		else 
			servicioTarea.eliminar(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
