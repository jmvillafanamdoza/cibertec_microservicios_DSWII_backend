package com.cibertec.tareas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.tareas.dto.UsuarioDTO;
import com.cibertec.tareas.entity.Usuario;
import com.cibertec.tareas.serviceImpl.UsuarioService;
import com.cibertec.tareas.utils.MensajeResponse;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService servicioUsu;
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")							
	public ResponseEntity<?> listar(){
		List<Usuario>lista=servicioUsu.listarTodos();
		if(lista==null) {
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje("No hay registros por ahora")
					.object(null).build(),HttpStatus.OK);
		}
		else {
			List<UsuarioDTO> data=lista.stream().map(m->   
				mapper.map(m, UsuarioDTO.class)).collect(Collectors.toList());
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje("Registros Actuales")
					.object(data).build(),HttpStatus.OK);		
		}
		
	}
	@PostMapping("/crear")
	public  ResponseEntity<?> grabar(@Valid @RequestBody UsuarioDTO bean){
		try {
			Usuario usu=mapper.map(bean, Usuario.class);
			Usuario u=servicioUsu.registrar(usu);
			UsuarioDTO dto=mapper.map(u, UsuarioDTO.class);
			
			return new ResponseEntity<>(MensajeResponse.builder()
						.mensaje("Guardado correctamente")
						.object(dto).build(),HttpStatus.CREATED);	
		} catch (Exception e) {
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje(e.getMessage())
					.object(null).build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}